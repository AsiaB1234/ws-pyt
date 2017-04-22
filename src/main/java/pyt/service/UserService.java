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

    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public UserService(UserRepository userRepository, TaskRepository taskRepository, ProjectRepository projectRepository) {
        super(userRepository);
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

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
