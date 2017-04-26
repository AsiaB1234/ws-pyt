package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Project;
import pyt.model.Task;
import pyt.repository.ProjectRepository;

@Service
public class ProjectService extends AbstractService<Project, ProjectRepository> {

    public Project addComment(Comment comment, Long id) {

        log.info("addComment");

        Project project = repository.findOne(id);
        project.addComment(comment);
        return repository.save(project);
    }

    public Project addCategory(Category category, Long id) {

        log.info("addCategory");

        Project project = repository.findOne(id);
        project.addCategory(category);
        return repository.save(project);
    }

    public Project addTask(Task task, Long id) {

        log.info("addTask");

        Project project = repository.findOne(id);
        project.addTask(task);
        return repository.save(project);
    }
}
