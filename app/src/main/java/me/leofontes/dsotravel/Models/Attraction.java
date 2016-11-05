package me.leofontes.dsotravel.Models;

/**
 * Created by Leo on 10/31/16.
 */

public class Attraction {
    protected int id;
    protected String name;
    protected String category;
    protected String description;
    protected String[] schedule;
    protected String photo;
    protected Boolean couvert;
    protected String latitude;
    protected String longitude;

    public Attraction(int id, String name, String category, String description, String[] schedule, String photo,
                      Boolean couvert, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.schedule = schedule;
        this.photo = photo;
        this.couvert = couvert;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String[] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[] schedule) {
        this.schedule = schedule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getCouvert() {
        return couvert;
    }

    public void setCouvert(Boolean couvert) {
        this.couvert = couvert;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
