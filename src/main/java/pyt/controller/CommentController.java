package pyt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Comment;
import pyt.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController extends AbstractController<Comment, CommentService> {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        super(commentService);
    }

    @RequestMapping(value = "/{id}/response", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment addResponse(@PathVariable Long id, Comment comment) {

        log.info("addResponse");

        return commentService.addResponse(comment, id);
    }

}
