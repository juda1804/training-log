package com.leotrainer.traininglog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Week {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planId", referencedColumnName = "id")
    private Plan plan;

    @NotNull
    private Boolean active;


    private Date startDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdDate;
}
