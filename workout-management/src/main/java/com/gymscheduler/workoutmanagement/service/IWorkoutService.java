package com.gymscheduler.workoutmanagement.service;

import com.gymscheduler.workoutmanagement.model.Workout;

import java.util.List;

public interface IWorkoutService {
    Workout createWorkout(Workout workout);
    List<Workout> getAllWorkouts();
    List<Workout> findByUserId(Long userId);
    void deleteWorkout(Long id);
}
