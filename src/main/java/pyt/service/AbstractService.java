package pyt.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pyt.repository.AbstractRepository;

public abstract class AbstractService<T, Repository extends AbstractRepository<T>> {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected AuthService authService;

    @Autowired
    protected Repository repository;

    public T getById(Long id) {

        log.info("getById");

        Long userId = authService.getCurrentLoggerUserId();

        return repository.findOne(id, -1);
    }

    public List<T> get() {

        log.info("get");

        Long id = authService.getCurrentLoggerUserId();

        return (List) repository.findAll();
    }

    public T save(T t) {

        log.info("save");

        Long id = authService.getCurrentLoggerUserId();

        return repository.save(t, 0);
    }

}
