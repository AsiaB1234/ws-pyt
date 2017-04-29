package pyt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pyt.model.Comment;
import pyt.model.Project;
import pyt.model.Task;
import pyt.service.ProjectService;

public class ProjectController extends AbstractController<Project, ProjectService> {

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addComment(@PathVariable Long id, @RequestBody Comment comment) {

        log.info("addComment");

        return service.addComment(comment, id);
    }

    @RequestMapping(value = "/{id}/categorys/categoryId", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addCategory(@PathVariable Long id, @PathVariable Long categoryId) {

        log.info("addCategory");

        return service.addCategory(id, categoryId);
    }

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addTask(@PathVariable Long id, @RequestBody Task task) {

        log.info("addTask");

        return service.addTask(task, id);
    }
}
