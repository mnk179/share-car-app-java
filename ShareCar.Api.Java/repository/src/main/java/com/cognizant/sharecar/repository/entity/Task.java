package com.cognizant.sharecar.repository.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Task {

    private Long taskId;
    private String title;
    private String description;
    private LocalDateTime endDate;
    private Status status;

}
