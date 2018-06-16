package com.uwefuchs.demo.heroestutorial.service.model;

public class Hero {
    private final int id;
    private final String name;

    public Hero (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
