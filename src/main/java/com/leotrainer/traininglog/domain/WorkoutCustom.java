package com.leotrainer.traininglog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutCustom {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    private Integer reps;

    @NotNull
    private Integer rounds;

    @NotNull
    private Integer RIR;

    @NotNull
    private String MDE; //Metodo de entrenamiento

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workout", referencedColumnName = "id")
    private Workout workout;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weekId", referencedColumnName = "id")
    private Workout week;
}
