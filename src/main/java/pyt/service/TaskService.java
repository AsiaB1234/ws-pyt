package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Task;
import pyt.repository.TaskRepository;

@Service
public class TaskService extends
        AbstractService<Task, TaskRepository> {

    @Autowired
    CategoryService categoryService;

    public Task addComment(Comment comment, Long id) {

        log.info("addComment");

        Task task = repository.findOne(id);
        if (task == null) {
            throw new PytServiceException("Task with given id doesn't exist.");
        }
        task.addComment(comment);
        return repository.save(task, 1);
    }

    public Task addCategory(Long id, Long categoryId) {

        log.info("addCategory");

        Category category = categoryService.getById(categoryId);
        if (category == null) {
            throw new PytServiceException("Category with given id doesn't exist.");
        }

        Task task = repository.findOne(id);
        if (task == null) {
            throw new PytServiceException("Task with given id doesn't exist.");
        }
        task.addCategory(category);
        return repository.save(task, 0);
    }

}
