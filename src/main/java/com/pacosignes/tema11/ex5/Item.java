package com.pacosignes.tema11.ex5;

public abstract class Item {

    int maxStack;
    String nombre="item";

    public Item() {
        maxStack=0;

    }

    public int getMaxStack(){
        return maxStack;
    }
    public String getNombre(){
        return nombre;
    }

}
