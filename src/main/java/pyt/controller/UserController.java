package pyt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Category;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.service.UserService;
import pyt.view.LoginRequest;
import pyt.view.UserView;

import javax.servlet.http.HttpSession;
import pyt.view.SignUpRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpSession session;

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView login(@RequestBody LoginRequest request, HttpSession session) {
        User user = userService.login(request.getEmail(), request.getPassword());
        session.setAttribute("userId", user.getId());
        return new UserView(user);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView signUp(@RequestBody SignUpRequest request, HttpSession session) {
        User user = userService.signUp(request);
        session.setAttribute("userId", user.getId());
        return new UserView(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView getById(@PathVariable Long id) {
        log.info("getById");
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        log.info("save");
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task addTask(@PathVariable Long id, @RequestBody Task task) {

        log.info("addTask");

        return userService.addTask(id, task);
    }

    @RequestMapping(value = "/{id}/projects", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addProject(@PathVariable Long id, @RequestBody Project project) {

        log.info("addProject");

        return userService.addProject(id, project);
    }

    @RequestMapping(value = "/{id}/categories", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@PathVariable Long id, @RequestBody Category category) {

        log.info("addCategory");

        return userService.addCategory(id, category);
    }
}
