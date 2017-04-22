package pyt.repository;

import org.springframework.stereotype.Repository;
import pyt.model.Task;

@Repository
public interface TaskRepository extends AbstractRepository<Task> {

}
