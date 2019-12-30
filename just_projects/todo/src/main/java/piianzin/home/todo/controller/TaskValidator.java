package piianzin.home.todo.controller;

import org.springframework.stereotype.Component;
import piianzin.home.todo.model.Task;
import piianzin.home.todo.model.dto.CreateTaskRequest;

import static org.valid4j.Assertive.require;

@Component
public class TaskValidator {

    public void validateTask(CreateTaskRequest task) {
        require(task.getTitle() != null, "title should be not null");
        require(task.getDescription() != null, "description should be not null");
    }

    public void validateId(String id) {
        require(!id.isBlank(), "id should be not blank");
    }

    public void validatePage(int page, int count) {
        require(page >= 0, "page should be more then 0");
        require(count > 0, "count should be more then 0");
    }
}
