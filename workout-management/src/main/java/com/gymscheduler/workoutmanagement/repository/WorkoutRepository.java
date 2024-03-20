package com.gymscheduler.workoutmanagement.repository;

import com.gymscheduler.workoutmanagement.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserId(Long userId);
}
