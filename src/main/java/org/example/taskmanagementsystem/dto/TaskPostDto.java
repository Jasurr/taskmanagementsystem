package org.example.taskmanagementsystem.dto;

import com.sun.istack.NotNull;
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
