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

    private ProjectRepository projectRepository;
    private CommentRepository commentRepository;
    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, CommentRepository commentRepository, TaskRepository taskRepository, CategoryRepository categoryRepository) {
        super(projectRepository);
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

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
