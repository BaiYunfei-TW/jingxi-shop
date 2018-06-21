package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.entity.Product;
import cn.cooode.jingxishop.repository.InventoryRepository;
import cn.cooode.jingxishop.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Api(value = "onlinestore", description = "Operations pertaining to products in Jingxi Shop")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("")
    public ResponseEntity save(@RequestBody Product product) {
        product.setCreateTime(new Date());
        product = productRepository.save(product);

        Inventory inventory = new Inventory();
        inventory.setId(product.getId());
        inventoryRepository.save(inventory);
        return ResponseEntity.status(201).location(URI.create("/products/"+product.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Product product, @PathVariable("id") Long id) {
        Product productToUpdate = productRepository.getOne(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());

        productRepository.save(productToUpdate);
        return ResponseEntity.status(204).build();
    }

    @ApiOperation(value = "View a product with the given id", response = Product.class)
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Product product = productRepository.getById(id);
        return ResponseEntity.ok(product);
    }

    @ApiOperation(value = "View a list of products", response = Iterable.class)
    @GetMapping("")
    public ResponseEntity getAll(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String description) {
        List<Product> products = productRepository.findAllByNameContainingAndDescriptionContaining(name, description);
        return ResponseEntity.ok(products);
    }

}
