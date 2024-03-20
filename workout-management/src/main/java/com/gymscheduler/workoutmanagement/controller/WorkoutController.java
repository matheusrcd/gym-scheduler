package com.gymscheduler.workoutmanagement.controller;

import com.gymscheduler.workoutmanagement.model.Workout;
import com.gymscheduler.workoutmanagement.service.WorkoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutServiceImpl workoutService;

    @Autowired
    public WorkoutController(WorkoutServiceImpl workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.createWorkout(workout));
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        return ResponseEntity.ok(workoutService.getAllWorkouts());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Workout>> getWorkoutsByUserId(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(workoutService.findByUserId(userId));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteWorkout(@PathVariable(name = "id") Long id) {
        try{
            workoutService.deleteWorkout(id);
            return ResponseEntity.ok("Deleted");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting");
        }
    }
}
