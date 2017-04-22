package pyt.model;

import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Comment {

    @GraphId
    private Long id;
    private String content;
    @Relationship(type = "SENDER")
    private User owner;
    @Relationship(type = "RESPONSE_COMMENT")
    private List<Comment> response = new LinkedList<>();

    public Comment() {
    }

    public Comment(Long id, String content, User owner) {
        this.id = id;
        this.content = content;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getOwner() {
        return owner;
    }

    public List<Comment> getResponse() {
        return response;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void addResponse(Comment comment) {
        response.add(comment);
    }

}
