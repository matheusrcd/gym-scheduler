package com.gymscheduler.workoutmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "workouts")
@Getter
@Setter
@NoArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column()
    private LocalDateTime startTime;

    @Column()
    private LocalDateTime endTime;

    @Column
    private String description;

    @Column
    private List<Long> workoutEquipmentsIds;

}
