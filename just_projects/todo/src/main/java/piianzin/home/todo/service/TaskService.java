package piianzin.home.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import piianzin.home.todo.model.Task;
import piianzin.home.todo.model.dto.CreateTaskRequest;
import piianzin.home.todo.repository.TaskRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void create(CreateTaskRequest taskDto) {
        Task task = new Task()
                .setCreateDate(new Date())
                .setTitle(taskDto.getTitle())
                .setDescription(taskDto.getDescription());

        taskRepository.save(task);
    }

    public Task find(String id) {
        return taskRepository.findById(id).orElse(new Task());
    }

    public Page findAll(int page, int count) {
        return taskRepository.findAll(PageRequest.of(page, count));
    }

    public void delete(String id) {
        Task task = find(id);
        taskRepository.delete(task);
    }

    public void update(Task task) {
        taskRepository.save(task);
    }
}
