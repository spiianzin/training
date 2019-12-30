package piianzin.home.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import piianzin.home.todo.model.Task;
import piianzin.home.todo.model.dto.CreateTaskRequest;
import piianzin.home.todo.model.dto.DoneTaskRequest;
import piianzin.home.todo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskValidator taskValidator;

    @PostMapping
    public void create(@RequestBody CreateTaskRequest task) {
        taskValidator.validateTask(task);
        taskService.create(task);
    }

    @PutMapping("/{id}")
    public void doneTask(@PathVariable String id, @RequestBody DoneTaskRequest doneRequest) {
        taskValidator.validateId(id);
        Task task = taskService.find(id);
        task.setDone(doneRequest.isDone());
        taskService.update(task);
    }

    @GetMapping
    public Task find(@RequestParam String id) {
        taskValidator.validateId(id);
        return taskService.find(id);
    }

    @GetMapping("/list/{page}/{count}")
    public List<Task> findAll(@PathVariable int page, @PathVariable int count) {
        taskValidator.validatePage(page, count);
        Page list = taskService.findAll(page, count);
        return list.getContent();
    }

    @DeleteMapping
    public void delete(String id) {
        taskValidator.validateId(id);
        taskService.delete(id);
    }

}
