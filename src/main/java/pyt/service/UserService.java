package pyt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.exception.PytServiceException;
import pyt.exception.UnauthorizedException;
import pyt.model.Category;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.repository.UserRepository;
import pyt.view.SignUpRequest;
import pyt.view.UserView;

@Service
public class UserService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthService authService;

    @Autowired
    protected UserRepository userRepository;

    public UserView getById(Long id) {
        log.info("getById");
        authService.verifyCurrentLoggedUser(id);
        return new UserView(userRepository.findOne(id, 3));
    }

    public User login(String email, String password) {

        log.info("login");

        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new PytServiceException("User with given email doesn't exist.");
        }

        if (user.getPassword() == null || !user.getPassword().equals(password)) {
            throw new UnauthorizedException();
        }
        return user;
    }

    public User signUp(SignUpRequest request) {

        log.info("signUp");

        if (request.getEmail().isEmpty()
                || request.getName().isEmpty()
                || request.getPassword().isEmpty()) {
            throw new PytServiceException("Invalid user values.");
        }
        User user = userRepository.findUserByEmail(request.getEmail());
        if (user != null) {
            throw new PytServiceException("User with given email already exist.");
        }
        user = new User(request.getName(), request.getPassword(), request.getEmail());
        return userRepository.save(user);
    }

    public Task addTask(Long id, Task task) {

        log.info("addTask");

        authService.verifyCurrentLoggedUser(id);

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new PytServiceException("User with given id doesn't exist.");
        }
        user.addTask(task);
        userRepository.save(user, 1);
        return task;
    }

    public Project addProject(Long id, Project project) {

        log.info("addProject");

        authService.verifyCurrentLoggedUser(id);

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new PytServiceException("User with given id doesn't exist.");
        }
        user.addProject(project);
        userRepository.save(user, 1);
        return project;
    }

    public Category addCategory(Long id, Category category) {

        log.info("addCategory");

        authService.verifyCurrentLoggedUser(id);

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new PytServiceException("User with given id doesn't exist.");
        }
        user.addCategory(category);
        userRepository.save(user, 1);
        return category;
    }

}
