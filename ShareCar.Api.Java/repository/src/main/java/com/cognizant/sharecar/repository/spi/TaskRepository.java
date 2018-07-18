package com.cognizant.sharecar.repository.spi;

import com.cognizant.sharecar.repository.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
