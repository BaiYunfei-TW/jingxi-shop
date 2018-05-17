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
        List<PurchaseItem> itemList = new ArrayList<>(purchaseItemList.size());
        int totalPrice = 0;
        for (PurchaseItemVo vo :
                purchaseItemList) {
            PurchaseItem item = new PurchaseItem();
            itemList.add(item);

            Product product = productRepository.getById(vo.getProductId());
            item.setPurchaseCount(vo.getPurchaseCount());
            item.setProduct(product);

            int purchasePrice = vo.getPurchaseCount() * product.getPrice();
            totalPrice += purchasePrice;

            item.setPurchasePrice(purchasePrice);
        }
        order.setCreateTime(new Date());
        order.setTotalPrice(totalPrice);
        return ResponseEntity.status(201).location(URI.create("")).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(orderRepository.getById(id));
    }

}
