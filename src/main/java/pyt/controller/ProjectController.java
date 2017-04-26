package pyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Project;
import pyt.model.Task;
import pyt.service.ProjectService;

public class ProjectController extends AbstractController<Project, ProjectService> {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addComment(@PathVariable Long id, @RequestBody Comment comment) {

        log.info("addComment");

        return projectService.addComment(comment, id);
    }

    @RequestMapping(value = "/{id}/categorys", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addCategory(@PathVariable Long id, @RequestBody Category category) {

        log.info("addCategory");

        return projectService.addCategory(category, id);
    }

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addTask(@PathVariable Long id, @RequestBody Task task) {

        log.info("addTask");

        return projectService.addTask(task, id);
    }
}
