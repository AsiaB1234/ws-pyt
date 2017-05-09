package pyt.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Project implements Serializable {

    @GraphId
    private Long id;
    private String name;
    @Relationship(type = "PROJECT_COMMENT")
    private List<Comment> comments = new LinkedList<>();
    @Relationship(type = "PROJECT_CATEGORY")
    private Category category;
    @Relationship(type = "PROJECT_TASK")
    private List<Task> tasks = new LinkedList<>();

    public Project() {
    }

    public Project(Long id, String name, List<Comment> comments, Category category, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.category = category;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Category getCategory() {
        return category;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
