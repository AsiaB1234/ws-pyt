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
public class Task implements Serializable {

    @GraphId
    private Long id;
    private String name;
    private Integer priority;
    @DateLong
    private Date endDate;
    private Boolean isImportant;
    private Boolean isDone;
    @Relationship(type = "TASK_COMMENT")
    private List<Comment> comments = new LinkedList<>();
    @Relationship(type = "TASK_CATEGORY")
    private Category category;

    public Task() {
    }

    public Task(Long id, String name, Integer priority, Date endDate, Boolean isImportant, Boolean isDone, List<Comment> comments, Category category) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.endDate = endDate;
        this.isImportant = isImportant;
        this.isDone = isDone;
        this.comments = comments;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Category getCategory() {
        return category;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
