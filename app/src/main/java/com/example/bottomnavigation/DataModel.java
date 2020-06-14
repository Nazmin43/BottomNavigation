package com.example.bottomnavigation;

class DataModel {
    String name;
    String version;
    int id_;
    int image;
    String desc;
    public DataModel(String name, String version, int id_, int image, String desc) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image=image;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }

    public String getDescription() {
        return desc;
    }
}

