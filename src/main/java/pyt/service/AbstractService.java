package pyt.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pyt.repository.AbstractRepository;

public abstract class AbstractService<T, Repository extends AbstractRepository<T>> {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected Repository repository;

    public T getById(Long id) {

        log.info("getById");

        return repository.findOne(id);
    }

    public List<T> get() {

        log.info("get");

        return (List) repository.findAll();
    }

    public T save(T t) {

        log.info("save");

        return repository.save(t, 1);
    }

    public T update(T t) {

        log.info("update");

        return repository.save(t, 0);
    }

}
