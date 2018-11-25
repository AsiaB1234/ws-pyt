package pyt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import pyt.repository.AbstractRepository;

public abstract class AbstractService<T, Repository extends AbstractRepository<T>> {

    @Autowired
    protected AuthService authService;

    @Autowired
    protected Repository repository;

    public T getById(Long id) {
        Long userId = authService.getCurrentLoggerUserId();

        return repository.findOne(id, -1);
    }

    public List<T> get() {
        Long id = authService.getCurrentLoggerUserId();

        return (List) repository.findAll();
    }

    public T save(T t) {
        Long id = authService.getCurrentLoggerUserId();

        return repository.save(t, 0);
    }

}
