package pyt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import javax.validation.Valid;
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
    public UserView signUp(@RequestBody @Valid SignUpRequest request, HttpSession session) {
        User user = userService.signUp(request);
        session.setAttribute("userId", user.getId());
        return new UserView(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public Long logged(HttpSession session) {
        return userService.logged();
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView getUser() {
        log.info("getById");
        return userService.getUser();
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task) {

        log.info("addTask");

        return userService.addTask(task);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addProject(@RequestBody Project project) {

        log.info("addProject");

        return userService.addProject(project);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {

        log.info("addCategory");

        return userService.addCategory(category);
    }
}
