package com.gassion;

import com.gassion.Entity.Entity;

import java.util.HashMap;

public class Map {
    private final int height;
    private final int weight;
    private HashMap<Coordinates, Entity> entity;

    public Map(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }



}
