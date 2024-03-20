package com.gymscheduler.equipmentmanagement.repository;

import com.gymscheduler.equipmentmanagement.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByOwnerId(Long ownerId);
}
