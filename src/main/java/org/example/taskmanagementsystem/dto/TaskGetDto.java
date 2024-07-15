package org.example.taskmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskmanagementsystem.model.TaskStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskGetDto {
    private Long id;
    private String title;
    private String description;
    private Long assignedTo;
    private TaskStatus status;
    private Date createdDate;
    private Date dueDate;
}
