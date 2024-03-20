package com.gymscheduler.equipmentmanagement.service;

import com.gymscheduler.equipmentmanagement.model.Equipment;

import java.util.List;

public interface IEquipmentService {

    Equipment createEquipment(Equipment equipment);
    List<Equipment> getAllEquipments();
    List<Equipment> findByOwnerId(Long ownerId);
    void deleteEquipment(Long id);
}
