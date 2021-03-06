package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.exception.PytServiceException;
import pyt.model.Project;
import pyt.model.Task;
import pyt.repository.ProjectRepository;

@Service
public class ProjectService extends AbstractService<Project, ProjectRepository> {

    @Autowired
    CategoryService categoryService;

    public Task addTask(Task task, Long id) {
      
        Long userId = authService.getCurrentLoggerUserId();

        Project project = repository.findOne(id);
        if (project == null) {
            throw new PytServiceException("Project with given id doesn't exist.");
        }
        project.addTask(task);
        repository.save(project, 1);
        return task;
    }
}
