package pyt.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pyt.service.AbstractService;

public abstract class AbstractController<T, S extends AbstractService> {

    Logger log = Logger.getLogger(this.getClass());

    private S s;

    @Autowired

    public AbstractController(S s) {
        this.s = s;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public T getById(@PathVariable Long id) {
        log.info("getById");
        return (T) s.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<T> get() {
        log.info("get");
        return s.get();
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public T save(T t) {
        log.info("save");
        return (T) s.save(t);
    }
}
