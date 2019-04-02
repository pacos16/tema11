package com.pacosignes.tema11.ex5;

import java.util.Scanner;

public class Main {

    static Scanner lector=new Scanner(System.in);
    static Inventario inventario= new Inventario(7);

    public static void main(String[] args) {
        int sobras;
        sobras=anyadir();
        System.out.println(sobras);
        inventario.printInventario();
        anyadir();
        inventario.printInventario();

    }


    private static int anyadir(){
        int opcion;
        Item item=new Item();
        do{

            menuItems();
            try {
                opcion = Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException nfe){
                opcion =-1;
            }
            if(opcion<0 || opcion>5){
                System.out.println("No correcto repita");
            }
        }while(opcion<0 || opcion>5);

        switch (opcion){
            case 1:
                item=new Pico();
                break;
            case 2:
                break;
            case 3:
                item=new Madera();

        }
        boolean correcto;
        int cantidad;
        do {
            correcto=true;
            System.out.println("quantos quieres anyadir");
            try {
                cantidad = Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException nfe){
                System.out.println("Caracter no correcto");
                correcto=false;
                cantidad=0;
            }
        }while(!correcto);


        return inventario.addItem(item,cantidad);

    }


    private static void menuItems(){

        System.out.println("Dime que item quieres anyadir");
        System.out.println("1. Pico");
        System.out.println("2. Espada");
        System.out.println("3. Madera");
        System.out.println("4. Piedra Ender");
        System.out.println("5. Huevo");
    }
}
