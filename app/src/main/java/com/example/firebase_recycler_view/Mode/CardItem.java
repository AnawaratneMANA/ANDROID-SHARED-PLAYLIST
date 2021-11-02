package com.example.firebase_recycler_view.Mode;

public class CardItem {
    private String name;
    private Integer image;
    private String description;
    private String subname;
    private String fireURL; // Will be used later.

    /**
     * Overloaded Constructor.
     * */
    public CardItem(String name, Integer image, String description, String subname) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.subname = subname;
    }

    /**
     * Overloaded Constructor.
     * */
    public CardItem(String name, Integer image, String description, String subname, String fireURL) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.subname = subname;
        this.fireURL = fireURL;
    }

    /**
     * Getters and Setters
     * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFireURL() {
        return fireURL;
    }

    public void setFireURL(String fireURL) {
        this.fireURL = fireURL;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
