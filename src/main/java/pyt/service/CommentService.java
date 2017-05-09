package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Comment;
import pyt.repository.CommentRepository;

@Service
public class CommentService extends
        AbstractService<Comment, CommentRepository> {

}
