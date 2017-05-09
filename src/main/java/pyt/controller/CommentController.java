package pyt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pyt.model.Comment;
import pyt.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController extends AbstractController<Comment, CommentService> {

}
