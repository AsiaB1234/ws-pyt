package pyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserService> {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User addTask(@PathVariable Long id, Task task) {

        log.info("addTask");

        return userService.addTask(id, task);
    }

    @RequestMapping(value = "/{id}/projects", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User addProject(@PathVariable Long id, Project project) {

        log.info("addProject");

        return userService.addProject(id, project);
    }
}
