package com.cognizant.sharecar.api.model.dto;

import com.cognizant.sharecar.common.spi.model.Priority;
import com.cognizant.sharecar.common.spi.model.TaskStatus;
import org.springframework.hateoas.Identifiable;

import java.time.LocalDateTime;

public class TaskView implements Identifiable<Long> {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime endDate;
    private TaskStatus status;
    private Priority priority;

    public TaskView() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskView{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
