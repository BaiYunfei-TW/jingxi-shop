package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.entity.Order;
import cn.cooode.jingxishop.entity.Product;
import cn.cooode.jingxishop.entity.PurchaseItem;
import cn.cooode.jingxishop.repository.InventoryRepository;
import cn.cooode.jingxishop.repository.OrderRepository;
import cn.cooode.jingxishop.repository.ProductRepository;
import cn.cooode.jingxishop.vo.PurchaseItemVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(description = "管理订单信息")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @ApiOperation(value = "创建订单")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "创建成功")
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody List<PurchaseItemVo> purchaseItemList) {
        Order order = new Order();
        List<PurchaseItem> itemList = new ArrayList<>(purchaseItemList.size()); //订单项目的列表

        int totalPrice = 0; //订单总价
        for (PurchaseItemVo vo :
                purchaseItemList) {
            //判断库存
            Inventory inventory = inventoryRepository.getById(vo.getProductId());
            if (inventory.getCount() - inventory.getLockedCount() < vo.getPurchaseCount()) {
                return ResponseEntity.status(4011).build();
            }

            PurchaseItem item = new PurchaseItem();
            itemList.add(item);

            Product product = productRepository.getById(vo.getProductId());
            item.setPurchaseCount(vo.getPurchaseCount());
            item.setProductId(product.getId());
            item.setProductDescription(product.getDescription());
            item.setProductName(product.getName());

            int purchasePrice = vo.getPurchaseCount() * product.getPrice();
            totalPrice += purchasePrice;

            item.setPurchasePrice(purchasePrice);

            //锁定库存
            inventory.setLockedCount(inventory.getLockedCount() + vo.getPurchaseCount());
            inventoryRepository.save(inventory);
        }
        order.setCreateTime(new Date());
        order.setTotalPrice(totalPrice);
        order.setPurchaseItemList(itemList);
        order.setStatus(Order.STATUS_UNPAID);

        order = orderRepository.save(order);
        return ResponseEntity.created(URI.create("/orders/"+order.getId())).build();
    }

    @ApiOperation(value = "更新订单状态")
    @PutMapping("/{id}")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "更新成功")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "订单id", required = true),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态", required = true, allowableValues = "unPaid,paid,finished,withdrawn")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity update(Long id, String orderStatus) {
        Order order = orderRepository.getById(id);
        order.setStatus(orderStatus);
        if (Order.STATUS_WITHDRAWN.equals(orderStatus)) {
            order.setWithdrawnTime(new Date());
            //撤销订单后，更新库存
            List<PurchaseItem> purchaseItems = orderRepository.getById(id).getPurchaseItemList();
            for (PurchaseItem item : purchaseItems) {
                //判断库存
                Inventory inventory = inventoryRepository.getOne(item.getProductId());
                inventory.setLockedCount(inventory.getLockedCount() - item.getPurchaseCount());

                inventoryRepository.save(inventory);
            }
        } else if (order.STATUS_PAID.equals(orderStatus)) {
            order.setPaidTime(new Date());
        } else {
            return ResponseEntity.badRequest().build();
        }

        orderRepository.save(order);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "查看订单详情")
    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@ApiParam(value = "订单id", required = true) @PathVariable Long id) {
        return ResponseEntity.ok(orderRepository.getById(id));
    }

    @ApiOperation(value = "查看user id对应的用户的所有订单信息")
    @GetMapping("")
    public ResponseEntity<List<Order>> getAll(@ApiParam(value = "用户id", required = true) @RequestParam(required = false, defaultValue = "") Long userId) {
        return ResponseEntity.ok(orderRepository.findAllByUserId(userId));
    }

}
