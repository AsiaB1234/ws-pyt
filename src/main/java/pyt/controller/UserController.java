package pyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Category;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.service.UserService;
import pyt.controller.model.LoginDto;
import pyt.controller.model.UserDto;
import pyt.controller.model.SignUpDto;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected HttpSession session;

    @Autowired
    protected UserService userService;


    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView login(@RequestBody LoginRequest request, HttpSession session) {
        User user = userService.login(request.getEmail(), request.getPassword());
        session.setAttribute("userId", user.getId());
        return new UserView(user);
    }

    @PostMapping(value = "/signUp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
      public UserView signUp(@RequestBody @Valid SignUpRequest request, HttpSession session) {
        User user = userService.signUp(request);
        session.setAttribute("userId", user.getId());
        return new UserView(user);
    }

    @PostMapping(value = "/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView getUser() {
        return userService.getUser();
    }

    @PostMapping(value = "/tasks",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task) {
        return userService.addTask(task);
    }

    @PostMapping(value = "/projects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Project addProject(@RequestBody Project project) {
        return userService.addProject(project);
    }

    @PostMapping(value = "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return userService.addCategory(category);
    }
}
