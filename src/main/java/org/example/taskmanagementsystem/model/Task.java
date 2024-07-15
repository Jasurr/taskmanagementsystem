package org.example.taskmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * название задачи
     */
    private String title;
    private String description;
    private Long assignedTo;
    private TaskStatus status;
    private Date createdDate;
    private Date dueDate;

}
