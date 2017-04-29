package pyt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.repository.UserRepository;
import pyt.view.UserView;

@Service
public class UserService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected UserRepository userRepository;

    public UserView getById(Long id) {

        log.info("getById");

        return new UserView(userRepository.findOne(id));
    }

    public User save(User user) {

        log.info("save");

        return userRepository.save(user, 1);
    }

    public User addTask(Long id, Task task) {

        log.info("addTask");

        User user = userRepository.findOne(id);
        user.addTask(task);
        return userRepository.save(user, 1);
    }

    public User addProject(Long id, Project project) {

        log.info("addProject");

        User user = userRepository.findOne(id);
        user.addProject(project);
        return userRepository.save(user, 1);
    }

}
