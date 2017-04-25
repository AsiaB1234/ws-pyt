package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;
import pyt.repository.ProjectRepository;
import pyt.repository.TaskRepository;
import pyt.repository.UserRepository;

@Service
public class UserService extends
        AbstractService<User, UserRepository> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public User addTask(Long id, Task task) {

        log.info("addTask");

        User user = userRepository.findOne(id);
        user.addTask(task);
        return userRepository.save(user);
    }

    public User addProject(Long id, Project project) {

        log.info("addProject");

        User user = userRepository.findOne(id);
        user.addProject(project);
        return userRepository.save(user);
    }

}
