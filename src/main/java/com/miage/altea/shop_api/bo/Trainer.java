package com.miage.altea.shop_api.bo;

import java.util.List;

public class Trainer {

    private int id;
    private String name;
    private int pokeMoney;
    private String password;
    private List<Object> bag;

    public Trainer() {

    }

    public Trainer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPokeMoney() {
        return pokeMoney;
    }

    public List<Object> getBag() {
        return bag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPokeMoney(int pokeMoney) {
        this.pokeMoney = pokeMoney;
    }

    public void setBag(List<Object> bag) {
        this.bag = bag;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
