package piianzin.home.todo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private Date createDate;
    private boolean isDone;
}
