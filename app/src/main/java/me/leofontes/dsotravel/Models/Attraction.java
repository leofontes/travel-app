package me.leofontes.dsotravel.Models;

/**
 * Created by Leo on 10/31/16.
 */

public class Attraction {
    protected int id;
    protected String name;
    protected String category;
    protected String description;
    protected Schedule schedule;
    protected String photo;

    public Attraction(int id, String name, String category, String description, Schedule schedule, String photo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.schedule = schedule;
        this.photo = photo;
    }

    public Attraction(int id, String name, String category, String description, String photo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
