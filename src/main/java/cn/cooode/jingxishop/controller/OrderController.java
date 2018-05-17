package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Order;
import cn.cooode.jingxishop.entity.Product;
import cn.cooode.jingxishop.entity.PurchaseItem;
import cn.cooode.jingxishop.repository.OrderRepository;
import cn.cooode.jingxishop.repository.ProductRepository;
import cn.cooode.jingxishop.vo.PurchaseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @PostMapping("")
    public ResponseEntity create(@RequestBody List<PurchaseItemVo> purchaseItemList) {
        Order order = new Order();
        List<PurchaseItem> itemList = new ArrayList<>(purchaseItemList.size()); //订单项目的列表

        int totalPrice = 0; //订单总价
        for (PurchaseItemVo vo :
                purchaseItemList) {
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
        }
        order.setCreateTime(new Date());
        order.setTotalPrice(totalPrice);
        order.setPurchaseItemList(itemList);

        order = orderRepository.save(order);
        return ResponseEntity.status(201).location(URI.create("/orders/"+order.getId())).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, String orderStatus) {
        Order order = orderRepository.getById(id);
        order.setStatus(orderStatus);
        if (Order.STATUS_WITHDRAWN.equals(orderStatus)) {
            order.setWithdrawnTime(new Date());
        } else if (order.STATUS_PAID.equals(orderStatus)) {
            order.setPaidTime(new Date());
        } else {
            return ResponseEntity.badRequest().build();
        }

        orderRepository.save(order);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id, Long userId) {
        return ResponseEntity.ok(orderRepository.getById(id));
    }

    @GetMapping("")
    public ResponseEntity getAll(@RequestParam(required = true) Long userId) {
        return ResponseEntity.ok(orderRepository.findAllByUserId(userId));
    }

}
