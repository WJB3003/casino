package io.zipcoder.casino;

public class Player {

    private String name;
    private int age;
    private double money = 0;


    public Player(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money += money;
    }
}
