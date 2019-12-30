package piianzin.home.todo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class DoneTaskRequest {
    private  boolean isDone;
}
