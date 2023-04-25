package com.badorek.luemon_app;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int health;
    protected int maxHealth;
    protected int experience;
    protected int wins;
    protected int lost;
    protected int trainingDays;


    protected int image;

    public Lutemon(String name, String color, int attack, int defense, int health, int maxHealth, int experience, int wins, int lost, int trainingDays) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = maxHealth;
        this.experience = experience;
        this.wins = wins;
        this.lost = lost;
        this.trainingDays = trainingDays;


    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public String getColor() {
        return color;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getWins() {
        return wins;
    }

    public int getLost() {
        return lost;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setTrainingDays(int trainingDays) {
        this.trainingDays = trainingDays;
    }

    public int getImage(String color) {
        if(color == "Valkoinen"){
            image = R.drawable.ic_android_white_24dp;
        } else if (color == "Musta") {
            image = R.drawable.ic_android_black_24dp;
        }else if (color == "Vihreä") {
            image = R.drawable.ic_android_green_24dp;
        }else if (color == "Pinkki") {
            image = R.drawable.ic_android_pink_24dp;
        }else if (color == "Oranssi") {
            image = R.drawable.ic_android_orange_24dp;
        }
        return image;
    }
}
