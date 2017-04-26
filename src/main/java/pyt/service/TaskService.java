package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Task;
import pyt.repository.TaskRepository;

@Service
public class TaskService extends
        AbstractService<Task, TaskRepository> {

    public Task addComment(Comment comment, Long id) {

        log.info("addComment");

        Task parent = repository.findOne(id);
        parent.addComment(comment);
        return repository.save(parent);
    }

    public Task addCategory(Category category, Long id) {

        log.info("addCategory");

        Task parent = repository.findOne(id);
        parent.addCategory(category);
        return repository.save(parent);
    }

}
