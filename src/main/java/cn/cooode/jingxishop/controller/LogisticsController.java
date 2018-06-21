package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.entity.LogisticsRecord;
import cn.cooode.jingxishop.entity.Order;
import cn.cooode.jingxishop.entity.PurchaseItem;
import cn.cooode.jingxishop.repository.InventoryRepository;
import cn.cooode.jingxishop.repository.LogisticsRecordRepository;
import cn.cooode.jingxishop.repository.OrderRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(description = "管理订单的配送记录")
@RestController
@RequestMapping("/logisticsRecords")
public class LogisticsController {

    @Autowired
    LogisticsRecordRepository recordRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @ApiOperation("根据物流订单Id查看物流详情")
    @GetMapping("/{id}")
    public ResponseEntity<LogisticsRecord> get(@ApiParam("配送记录的id") @PathVariable Long id) {
        return ResponseEntity.ok(recordRepository.getById(id));
    }

    @ApiOperation("根据物流订单Id更新物流状态")
    @PutMapping("/{id}/orders/{orderId}")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "物流订单的id", required = true),
            @ApiImplicitParam(name = "orderId", value = "商品订单的id", required = true),
            @ApiImplicitParam(name = "logisticsStatus", value = "物流订单的状态", required = true, allowableValues = "shipping,signed")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "更新成功")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<LogisticsRecord> update(@PathVariable(name = "id") Long id, @PathVariable(name = "orderId") Long orderId, @RequestParam(required = true) String logisticsStatus) {
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
        return ResponseEntity.noContent().build();
    }

}
