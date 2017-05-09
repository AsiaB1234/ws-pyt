package pyt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Comment;
import pyt.model.Task;
import pyt.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController extends AbstractController<Task, TaskService> {

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task addComment(@PathVariable Long id, @RequestBody Comment comment) {

        log.info("addComment");

        return service.addComment(comment, id);
    }

    @RequestMapping(value = "/{id}/category/{categoryId}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task setCategory(@PathVariable Long id, @PathVariable Long categoryId) {

        log.info("setCategory");

        return service.setCategory(id, categoryId);
    }

}
