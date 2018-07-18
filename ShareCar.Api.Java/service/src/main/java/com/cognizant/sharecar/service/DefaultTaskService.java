package com.cognizant.sharecar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class DefaultTaskService implements TaskService {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAll(GetAllQuery getAllQuery) {
        if (getAllQuery.getStatus() != null) {
            return tasks.stream().filter(task -> task.getStatus() == getAllQuery.getStatus()).collect(toList());
        }
        return tasks;
    }

    @Override
    public void add(Task task) {
        task.setId(getUniqueId());
        tasks.add(task);
    }

    @Override
    public void delete(Task task) {
        tasks.remove(task);
    }

    private int getUniqueId() {
        return new Random().ints(5).reduce((a, b) -> a * 10 + b).getAsInt();
    }
}
