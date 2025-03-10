package com.samvel.uexample;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    private Integer id;

    private Urgency urgency;

    private Category category;

    private String title;

    private String description;

    private LocalDate created;

    private LocalDate eta;

    private Boolean completed;

    public Task() {
    }

    public Task(Urgency urgency, Category category, String title, String description, LocalDate eta) {
        this.urgency = urgency;
        this.category = category;
        this.title = title;
        this.description = description;
        this.eta = eta;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setEta(LocalDate eta) {
        this.eta = eta;
    }

    public LocalDate getEta() {
        return eta;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
