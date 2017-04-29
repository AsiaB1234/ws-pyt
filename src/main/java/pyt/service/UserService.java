package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.repository.UserRepository;

@Service
public class UserService extends
        AbstractService<User, UserRepository> {

    public User addTask(Long id, Task task) {

        log.info("addTask");

        User user = repository.findOne(id);
        user.addTask(task);
        return repository.save(user, 1);
    }

    public User addProject(Long id, Project project) {

        log.info("addProject");

        User user = repository.findOne(id);
        user.addProject(project);
        return repository.save(user, 1);
    }

}
