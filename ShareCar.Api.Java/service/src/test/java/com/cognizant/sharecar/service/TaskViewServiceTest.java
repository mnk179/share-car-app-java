package com.cognizant.sharecar.service;

import com.cognizant.sharecar.common.spi.model.TaskStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class TaskViewServiceTest {

    private TaskService taskService;

    @Before
    public void setUp() {
        taskService = new DefaultTaskService();
    }

    @Test
    public void getAll_NoTasksWereAdded_ReturnEmptyTaskList() {
        List<TaskView> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_OneTaskWasAdded_ReturnOneTask() {
        addTask(TaskStatus.DONE);

        List<TaskView> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(1));
    }

    @Test
    public void getAll_StatusIsDone_ReturnEmpty() {
        addTask(TaskStatus.OPEN);
        List<TaskView> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_TwoTasksWereAddedAndStatusIsDone_OneIsReturned() {
        addTask(TaskStatus.DONE);
        List<TaskView> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(1));
    }

    @Test
    public void getAll_TwoTasksWereAddedAndStatusIsAbsent_ReturnTwoTasks() {
        addTask(TaskStatus.OPEN);
        addTask(TaskStatus.DONE);
        List<TaskView> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(2));
    }

    @Test
    public void delete_AddOneTask_OneTaskIsDeleted() {
        addTask(TaskStatus.DONE);
        addTask(TaskStatus.OPEN);
        addTask(TaskStatus.IN_PROGRESS);
        List<TaskView> tasks = taskService.getAll(new GetAllQuery());

        TaskView task = tasks.get(0);
        taskService.delete(task);

        List<TaskView> fetchedTasksAfterDelete = taskService.getAll(new GetAllQuery());

        assertThat(fetchedTasksAfterDelete, hasSize(2));
    }

    private void addTask(TaskStatus taskStatus) {
        TaskView task = new TaskView();
        task.setStatus(taskStatus);
        taskService.add(task);
    }
}
