package pyt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Task;
import pyt.service.TaskService;
import pyt.view.ValueView;

@RestController
@RequestMapping("/tasks")
public class TaskController extends AbstractController<Task, TaskService> {

    @PostMapping(value = "/{id}/comments",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment addComment(@PathVariable Long id, @RequestBody Comment comment) {
        return service.addComment(comment, id);
    }

    @PutMapping(value = "/{id}/category",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Category setCategory(@PathVariable Long id, @RequestBody Long categoryId) {
        return service.setCategory(id, categoryId);
    }

}
