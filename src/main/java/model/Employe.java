package model;


import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private ArrayList<String> Skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getSkills() {
        return Skills;
    }

    public void setSkills(ArrayList<String> skills) {
        Skills = skills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employe(String name, String email, ArrayList<String> skills) {
        name = name;
        this.email = email;
        Skills = skills;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public Employe() {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "implaication",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Project_id", referencedColumnName = "ID")
    )
    private ArrayList<Project>  projects = new ArrayList<>();
    public void addEmplyee(Project project) {
        this.projects.add(project);
    }
}



