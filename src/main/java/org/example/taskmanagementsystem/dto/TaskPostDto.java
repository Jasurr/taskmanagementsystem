package org.example.taskmanagementsystem.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.example.taskmanagementsystem.model.TaskStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskPostDto {
    private Long id;
    @NotNull
    private String title;
    private String description;
    private Long assignedTo;
    private TaskStatus status;
    private Date createdDate;
    private Date dueDate;
}
