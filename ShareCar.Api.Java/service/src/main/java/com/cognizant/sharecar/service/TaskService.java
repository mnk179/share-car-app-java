package com.cognizant.sharecar.service;

import java.util.List;

public interface TaskService {

    List<TaskView> getAll(GetAllQuery getAllQuery);

    void add(TaskView task);

    void delete(TaskView task);
}
