package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.entity.Product;
import cn.cooode.jingxishop.repository.InventoryRepository;
import cn.cooode.jingxishop.repository.ProductRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Api(description = "商品管理")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("")
    @ApiOperation(value = "添加新的商品")
    @ApiResponses({
            @ApiResponse(message = "OK", code = 201, responseHeaders = {@ResponseHeader(name = "location", description = "Path to view the new product")})
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@RequestBody Product product) {
        product.setCreateTime(new Date());
        product = productRepository.save(product);

        Inventory inventory = new Inventory();
        inventory.setId(product.getId());
        inventoryRepository.save(inventory);
        return ResponseEntity.created(URI.create("/products/"+product.getId())).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新商品信息")
    @ApiResponses({
            @ApiResponse(message = "更新成功", code = 204)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true),
            @ApiImplicitParam(name = "product", value = "商品信息", required = true)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Product product, @PathVariable("id") Long id) {
        Product productToUpdate = productRepository.getOne(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());

        productRepository.save(productToUpdate);
    }

    @ApiOperation(value = "查看商品信息", response = Product.class)
    @GetMapping("/{id}")
    public ResponseEntity get(@ApiParam(value = "商品id", required = true)@PathVariable Long id) {
        Product product = productRepository.getById(id);
        return ResponseEntity.ok(product);
    }

    @ApiOperation(value = "查看所有商品信息（模糊搜索）")
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = Product.class, responseContainer = "List", message = "OK")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "商品名称"),
            @ApiImplicitParam(name = "description", value = "商品描述")
    })
    @GetMapping("")
    public ResponseEntity getAll(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "") String description) {
        List<Product> products = productRepository.findAllByNameContainingAndDescriptionContaining(name, description);
        return ResponseEntity.ok(products);
    }

}
