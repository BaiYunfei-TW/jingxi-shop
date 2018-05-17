package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.entity.LogisticsRecord;
import cn.cooode.jingxishop.entity.Order;
import cn.cooode.jingxishop.entity.PurchaseItem;
import cn.cooode.jingxishop.repository.InventoryRepository;
import cn.cooode.jingxishop.repository.LogisticsRecordRepository;
import cn.cooode.jingxishop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logisticsRecords")
public class LogisticsController {

    @Autowired
    LogisticsRecordRepository recordRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(recordRepository.getById(id));
    }

    @PutMapping("/{id}/orders/{orderId}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @PathVariable(name = "orderId") Long orderId, @RequestParam(required = true) String logisticsStatus) {
        LogisticsRecord logisticsRecord = recordRepository.getById(id);
        logisticsRecord.setLogisticsStatus(logisticsStatus);

        if (LogisticsRecord.STATUS_SHIPPING.equals(logisticsStatus)) {
            logisticsRecord.setOutboundTime(new Date());
        } else if (logisticsRecord.STATUS_SIGNED.equals(logisticsStatus)) {
            logisticsRecord.setSignedTime(new Date());
            //签收后，更新真实库存
            List<PurchaseItem> purchaseItems = orderRepository.getById(orderId).getPurchaseItemList();
            for (PurchaseItem item : purchaseItems) {
                Inventory inventory = inventoryRepository.getOne(item.getProductId());
                inventory.setLockedCount(inventory.getLockedCount() - item.getPurchaseCount());
                inventory.setCount(inventory.getCount() - item.getPurchaseCount());

                inventoryRepository.save(inventory);
            }
        }

        recordRepository.save(logisticsRecord);
        return ResponseEntity.status(204).build();
    }

}
