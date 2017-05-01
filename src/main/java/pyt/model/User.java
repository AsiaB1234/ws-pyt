package pyt.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User implements Serializable {

    @GraphId
    private Long id;
    private String name;
    private String password;
    private String email;
    @Relationship(type = "USER_TASK")
    private List<Task> tasks = new LinkedList<>();
    @Relationship(type = "USER_PROJECT")
    private List<Project> projects = new LinkedList<>();
    @Relationship(type = "USER_CATEGORY")
    private List<Category> categories = new LinkedList<>();

    public User() {
    }

    public User(Long id, String name, String password, String email, List<Task> tasks, List<Project> projects, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tasks = tasks;
        this.projects = projects;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

}
