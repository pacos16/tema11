package com.pacosignes.tema11.ex5;

public class Main {



    public static void main(String[] args) {
        Inventario inventario= new Inventario(7);
        int sobras;
        sobras=inventario.addItem();
        System.out.println(sobras);
        inventario.printInventario();
    }
}
