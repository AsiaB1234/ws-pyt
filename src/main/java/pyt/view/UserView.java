package pyt.view;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import pyt.model.Category;
import pyt.model.Project;
import pyt.model.Task;
import pyt.model.User;

public class UserView implements Serializable {

    private Long id;
    private String name;
    private List<Task> tasks = new LinkedList<>();
    private List<Project> projects = new LinkedList<>();
    private List<Category> categories = new LinkedList<>();

    public UserView() {
    }

    public UserView(Long id, String name, List<Task> tasks, List<Project> projects, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.projects = projects;
        this.categories = categories;
    }

    public UserView(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.tasks = user.getTasks();
        this.projects = user.getProjects();
        this.categories = user.getCategories();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

}
