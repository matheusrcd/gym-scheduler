package com.gymscheduler.equipmentmanagement.controller;

import com.gymscheduler.equipmentmanagement.model.Equipment;
import com.gymscheduler.equipmentmanagement.service.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentServiceImpl equipmentService;

    @Autowired
    public EquipmentController(EquipmentServiceImpl equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment user) {
        return ResponseEntity.ok(equipmentService.createEquipment(user));
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        return ResponseEntity.ok(equipmentService.getAllEquipments());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteEquipment(@PathVariable(name = "id") Long id) {
        try{
            equipmentService.deleteEquipment(id);
            return ResponseEntity.ok("Deleted");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting");
        }
    }
}
