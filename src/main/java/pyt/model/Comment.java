package pyt.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public class Comment {

    @GraphId
    private Long id;
    private String content;
    @DateLong
    private Date addedDate;
    @Relationship(type = "SENDER")
    private User owner;
    @Relationship(type = "RESPONSE_COMMENT")
    private List<Comment> response = new LinkedList<>();

    public Comment() {
    }

    public Comment(Long id, String content, Date addedDate, User owner, List<Comment> response) {
        this.id = id;
        this.content = content;
        this.addedDate = addedDate;
        this.owner = owner;
        this.response = response;
        if (addedDate == null && id == null) {
            addedDate = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getAddedDate() {
        return addedDate;
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
