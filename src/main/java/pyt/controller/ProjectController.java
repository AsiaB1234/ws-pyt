package pyt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Project;
import pyt.model.Task;
import pyt.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController extends AbstractController<Project, ProjectService> {

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task addTask(@PathVariable Long id, @RequestBody Task task, @RequestBody Long userId) {

        log.info("addTask");

        return service.addTask(task, id, userId);
    }
}
