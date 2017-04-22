package pyt.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pyt.repository.AbstractRepository;

public abstract class AbstractService<T, R extends AbstractRepository<T>> {

    Logger log = Logger.getLogger(this.getClass());

    private R r;

    @Autowired
    public AbstractService(R r) {
        this.r = r;
    }

    public T getById(Long id) {

        log.info("getById");

        return r.findOne(id);
    }

    public List<T> get() {

        log.info("get");

        return (List) r.findAll();
    }

    public T save(T t) {

        log.info("save");

        return r.save(t);
    }

}
