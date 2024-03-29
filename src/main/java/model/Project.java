package model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private double budget;


    public Project(String title, double budget, ArrayList<Employe> employes) {
        this.title = title;
        this.budget = budget;

    }



}
