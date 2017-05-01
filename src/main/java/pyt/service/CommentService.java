package pyt.service;

import org.springframework.stereotype.Service;
import pyt.model.Comment;
import pyt.repository.CommentRepository;

@Service
public class CommentService extends
        AbstractService<Comment, CommentRepository> {

    public Comment addResponse(Comment comment, Long id) {

        log.info("addResponse");

        Comment parent = repository.findOne(id);
        if (parent == null) {
            throw new PytServiceException("Comment with given id doesn't exist.");
        }
        parent.addResponse(comment);
        return repository.save(parent, 1);
    }

}
