package com.pacosignes.tema11.ex5;

import java.util.Scanner;

public class Inventario {

    static Scanner lector=new Scanner (System.in);



    private Slot[] inventario;


    public Inventario(int numSlots) {
        this.inventario = new Slot[numSlots];

        for(int i=0;i<numSlots;i++){
            inventario[i]=new Slot();
        }
    }



    public int addItem(){
        int opcion;
        Item item;
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
            }
        }while(!correcto);

        boolean espacio=true;

        while(espacio && cantidad>0){
            for(int i=0;i<inventario.length;i++){
                if(inventario[i] instanceof )
            }
        }
    }



    private void menuItems(){

        System.out.println("Dime que item quieres anyadir");
        System.out.println("1. Pico");
        System.out.println("2. Espada");
        System.out.println("3. Madera");
        System.out.println("4. Piedra Ender");
        System.out.println("5. Huevo");
    }





}