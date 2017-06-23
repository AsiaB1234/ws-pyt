package pyt.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public User login(String email, String password) {

        log.info("login");

        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new PytServiceException("User with given email doesn't exist.");
        }

        String hashedPassword = hashPassword(password);
        if (user.getPassword() == null || !user.getPassword().equals(hashedPassword)) {
            throw new UnauthorizedException();
        }
        return user;
    }

    public User signUp(SignUpRequest request) {

        log.info("signUp");

        User user = userRepository.findUserByEmail(request.getEmail());
        if (user != null) {
            throw new PytServiceException("User with given email already exist.");
        }
        user = new User(request.getName(), hashPassword(request.getPassword()), request.getEmail());
        return userRepository.save(user);
    }

    public Long logged() {
        return authService.getCurrentLoggerUserId();
    }

    public UserView getUser() {
        log.info("getById");
        Long id = authService.getCurrentLoggerUserId();
        return new UserView(userRepository.findOne(id, 3));
    }

    public Task addTask(Task task) {

        log.info("addTask");

        Long id = authService.getCurrentLoggerUserId();

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new PytServiceException("User with given id doesn't exist.");
        }
        user.addTask(task);
        userRepository.save(user, 1);
        return task;
    }

    public Project addProject(Project project) {

        log.info("addProject");

        Long id = authService.getCurrentLoggerUserId();

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new PytServiceException("User with given id doesn't exist.");
        }
        user.addProject(project);
        userRepository.save(user, 1);
        return project;
    }

    public Category addCategory(Category category) {

        log.info("addCategory");

        Long id = authService.getCurrentLoggerUserId();

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new PytServiceException("User with given id doesn't exist.");
        }
        user.addCategory(category);
        userRepository.save(user, 1);
        return category;
    }

    public String hashPassword(String password) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update("someAdditionalString".getBytes());
            byte[] bytes = md.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
