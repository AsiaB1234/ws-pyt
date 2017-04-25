package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Project;
import pyt.model.Task;
import pyt.repository.CategoryRepository;
import pyt.repository.CommentRepository;
import pyt.repository.ProjectRepository;
import pyt.repository.TaskRepository;

@Service
public class ProjectService extends AbstractService<Project, ProjectRepository> {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Project addComment(Comment comment, Long id) {

        log.info("addComment");

        Project project = projectRepository.findOne(id);
        project.addComment(comment);
        return projectRepository.save(project);
    }

    public Project addCategory(Category category, Long id) {

        log.info("addCategory");

        Project project = projectRepository.findOne(id);
        project.addCategory(category);
        return projectRepository.save(project);
    }

    public Project addTask(Task task, Long id) {

        log.info("addTask");

        Project project = projectRepository.findOne(id);
        project.addTask(task);
        return projectRepository.save(project);
    }
}
