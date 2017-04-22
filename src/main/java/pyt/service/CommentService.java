package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Comment;
import pyt.repository.CommentRepository;

@Service
public class CommentService extends
        AbstractService<Comment, CommentRepository> {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
    }

    public Comment addResponse(Comment comment, Long id) {

        log.info("addResponse");

        Comment parent = commentRepository.findOne(id);
        parent.addResponse(comment);
        return commentRepository.save(parent);
    }

}
