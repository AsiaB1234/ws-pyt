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

        Task parent = repository.findOne(id);
        parent.addComment(comment);
        return repository.save(parent, 1);
    }

    public Task addCategory(Long id, Long categoryId) {

        log.info("addCategory");

        Category category = categoryService.getById(categoryId);

        Task parent = repository.findOne(id);
        parent.addCategory(category);
        return repository.save(parent, 0);
    }

}
