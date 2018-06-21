package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.repository.InventoryRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(description = "商品库存管理")
@RestController
@RequestMapping("/inventories")
public class InventoryContorller {

    @Autowired
    InventoryRepository inventoryRepository;

    @ApiOperation(value = "更新商品的库存信息")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "更新成功")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity update(@ApiParam(value = "商品id", required = true) @PathVariable Long id,
                                 @ApiParam(value = "库存信息", required = true) @RequestBody Inventory inventory) {
        Inventory inventoryToUpdate = inventoryRepository.getOne(id);
        inventoryToUpdate.setCount(inventory.getCount());
        inventoryRepository.save(inventoryToUpdate);
        return ResponseEntity.noContent().build();
    }

}
