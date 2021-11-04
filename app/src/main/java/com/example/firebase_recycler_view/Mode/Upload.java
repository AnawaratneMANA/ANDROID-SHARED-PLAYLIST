package com.example.firebase_recycler_view.Mode;

public class Upload {
    private String name;
    private String subName;
    private String imageUrl;
    private String description;
    private String category;
    private boolean state;

    public Upload(){

    }

    public Upload(String name, String subName, String imageUrl, String description, String category, boolean state) {

        //Validation
        if(name.trim().equals("")){
            name ="No name";
        }

        if(subName.trim().equals("")){
            name ="No subname";
        }

        if(description.trim().equals("")){
            name ="No description";
        }

        this.name = name;
        this.subName = subName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
