package pyt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public class Comment implements Serializable {

    @GraphId
    private Long id;
    private String content;
    @DateLong
    private Date addedDate;
    private Long ownerId;
    private String ownerName;
    @Relationship(type = "RESPONSE_COMMENT")
    private List<Comment> response = new LinkedList<>();

    public Comment() {
    }

    public Comment(Long id, String content, Date addedDate, Long ownerId, String ownerName, List<Comment> response) {
        this.id = id;
        this.content = content;
        this.addedDate = addedDate;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public List<Comment> getResponse() {
        return response;
    }

    public void addResponse(Comment comment) {
        response.add(comment);
    }

}
