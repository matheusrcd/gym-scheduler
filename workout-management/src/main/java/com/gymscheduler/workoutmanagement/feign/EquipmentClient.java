package com.gymscheduler.workoutmanagement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "equipment-management", url = "http://equipment-management:8080")
public interface EquipmentClient {
    @GetMapping("/api/equipment/{id}/availability")
    ResponseEntity<Boolean> checkEquipmentAvailability(@PathVariable("id") Long equipmentId);
}

