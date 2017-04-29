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
    private List<Category> categories = new LinkedList<>();

    public Task() {
    }

    public Task(Long id, String name, Integer priority, Date endDate, Boolean isImportant, Boolean isDone, List<Comment> comments, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.endDate = endDate;
        this.isImportant = isImportant;
        this.isDone = isDone;
        this.comments = comments;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

}
