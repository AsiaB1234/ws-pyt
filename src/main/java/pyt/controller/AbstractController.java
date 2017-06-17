package pyt.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pyt.service.AbstractService;

public abstract class AbstractController<T, Service extends AbstractService> {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected Service service;

    @RequestMapping(value = "/{id}/{userId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public T getById(@PathVariable Long id, @PathVariable Long userId) {
        log.info("getById");
        return (T) service.getById(id, userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<T> get(@PathVariable Long userId) {
        log.info("get");
        return service.get(userId);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public T save(@RequestBody T t, @RequestBody Long userId) {
        log.info("save");
        return (T) service.save(t, userId);
    }
}
