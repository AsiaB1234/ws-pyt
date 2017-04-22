package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Task;
import pyt.repository.CategoryRepository;
import pyt.repository.CommentRepository;
import pyt.repository.TaskRepository;

@Service
public class TaskService extends
        AbstractService<Task, TaskRepository> {

    private TaskRepository taskRepository;
    private CommentRepository commentRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, CommentRepository commentRepository, CategoryRepository categoryRepository) {
        super(taskRepository);
        this.commentRepository = commentRepository;
        this.categoryRepository = categoryRepository;
    }

    public Task addComment(Comment comment, Long id) {

        log.info("addComment");

        Task parent = taskRepository.findOne(id);
        parent.addComment(comment);
        return taskRepository.save(parent);
    }

    public Task addCategory(Category category, Long id) {

        log.info("addCategory");

        Task parent = taskRepository.findOne(id);
        parent.addCategory(category);
        return taskRepository.save(parent);
    }

}
