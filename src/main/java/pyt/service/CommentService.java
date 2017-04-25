package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Comment;
import pyt.repository.CommentRepository;

@Service
public class CommentService extends
        AbstractService<Comment, CommentRepository> {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addResponse(Comment comment, Long id) {

        log.info("addResponse");

        Comment parent = commentRepository.findOne(id);
        parent.addResponse(comment);
        return commentRepository.save(parent);
    }

}
