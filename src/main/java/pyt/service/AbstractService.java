package pyt.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pyt.repository.AbstractRepository;

public abstract class AbstractService<T, Repository extends AbstractRepository<T>> {

    Logger log = Logger.getLogger(this.getClass());

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

        return repository.save(t);
    }

}
