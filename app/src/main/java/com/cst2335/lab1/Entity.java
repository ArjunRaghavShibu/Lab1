package com.cst2335.lab1;

public class Entity {
    private int type;
    private String name;
    private String text_type;
    private String description;

    public Entity(int type, String name, String text_type, String description) {
        this.type = type;
        this.name = name;
        this.text_type = text_type;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTextType() {
        return text_type;
    }

    public String getDescription() {
        return description;
    }
}
