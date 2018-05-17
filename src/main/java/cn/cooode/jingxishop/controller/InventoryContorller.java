package cn.cooode.jingxishop.controller;

import cn.cooode.jingxishop.entity.Inventory;
import cn.cooode.jingxishop.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryContorller {

    @Autowired
    InventoryRepository inventoryRepository;

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory inventoryToUpdate = inventoryRepository.getOne(id);
        inventoryToUpdate.setCount(inventory.getCount());
        inventoryRepository.save(inventoryToUpdate);
        return ResponseEntity.status(204).build();
    }

}
