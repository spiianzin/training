package piianzin.home.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import piianzin.home.todo.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
