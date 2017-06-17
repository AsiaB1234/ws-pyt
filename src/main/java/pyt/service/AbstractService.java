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

    public T getById(Long id, Long userId) {

        log.info("getById");

        authService.verifyCurrentLoggedUser(userId);

        return repository.findOne(id, -1);
    }

    public List<T> get(Long userId) {

        log.info("get");

        authService.verifyCurrentLoggedUser(userId);

        return (List) repository.findAll();
    }

    public T save(T t, Long userId) {

        log.info("save");

        authService.verifyCurrentLoggedUser(userId);

        return repository.save(t, 0);
    }

}
