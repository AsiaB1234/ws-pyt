package pyt.model;

import java.io.Serializable;
import java.util.Date;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

@NodeEntity
public class Comment implements Serializable {

    @GraphId
    private Long id;
    private String content;
    @DateLong
    private Date addedDate;

    public Comment() {
    }

    public Comment(Long id, String content, Date addedDate) {
        this.id = id;
        this.content = content;
        this.addedDate = addedDate;
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
}
