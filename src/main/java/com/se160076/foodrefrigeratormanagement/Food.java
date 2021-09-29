/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se160076.foodrefrigeratormanagement;

import java.util.Comparator;

/**
 *
 * @author Tony
 */
public class Food implements Comparable<Food> {

    private String id;
    private String name;
    private int weight;
    private String type;
    private String place;
    private String expiredDate;

    public Food() {
    }

    ;
    
    public Food(String id, String name, int weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public int compareTo(Food f) {
        return f.getExpiredDate().compareTo(getExpiredDate());
    }

    public void print() {
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", getId(), getName(), getWeight() + " (g)", getType(), getPlace(), getExpiredDate());
    }

    public String toString() {
        return id + "," + name + "," + weight + "," + type + "," + place + "," + expiredDate;
    }
    
}
