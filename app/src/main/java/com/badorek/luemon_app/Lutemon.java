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

    protected int image;

    public Lutemon(String name, String color, int attack, int defense, int health, int maxHealth, int experience) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = maxHealth;
        this.experience = experience;

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
