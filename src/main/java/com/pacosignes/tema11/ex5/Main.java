package com.pacosignes.tema11.ex5;

import java.util.Scanner;

public class Main {

    static Scanner lector=new Scanner(System.in);
    static Inventario inventario= new Inventario(7);

    public static void main(String[] args) {
        int opcion;
        do{

            opcion=menu();

            switch (opcion){
                case 1:
                    int sobras=anyadir();
                    if(sobras>0) {
                        System.out.println("Han sobrado "+sobras);
                    }
                    System.out.println("Intro para continuar");
                    lector.nextLine();
                    break;
                case 2:
                    borrar();
                    break;
                case 3:
                    inventario.printInventario();
                    System.out.println("Intro para continuar");
                    lector.nextLine();
                    break;
            }

        }while(opcion!=0);


    }
    private static int menu(){
        int opcion;
        do {
            System.out.println("Elije una opcion");
            System.out.println("----------------");
            System.out.println("1.Anyadir objetos");
            System.out.println("2.Borrar objetos");
            System.out.println("3.Mostrar inventario");
            System.out.println("--------------------");
            System.out.println("0.Salir");

            try{
                opcion= Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException nfe){
                opcion=-1;

            }
            if(opcion<0 || opcion>3){
                System.out.println("Introduce un numero en el rango");
                System.out.println("Intro para continuar");
                lector.nextLine();
            }

        }while (opcion<0 || opcion>3);

        return opcion;

    }



    private static int anyadir(){

        Item item=menuItems();
           if(item!=null) {
               boolean correcto;
               int cantidad;
               do {
                   correcto = true;
                   System.out.println("quantos quieres anyadir");
                   try {
                       cantidad = Integer.parseInt(lector.nextLine());
                   } catch (NumberFormatException nfe) {
                       System.out.println("Caracter no correcto");
                       correcto = false;
                       cantidad = 0;
                   }
               } while (!correcto);


               return inventario.addItem(item, cantidad);
           }
           return 0;
    }
    private static void borrar(){
        int total;
        Item item;
        do{
            System.out.println("Que objeto deseas borrar?");
            item=menuItems();
            if(item!=null) {
                total = inventario.countItem(item);
                if (total <= 0) {
                    System.out.println("No tienes objetos  de este tipo disponibles disponibles");
                }else{
                    System.out.println("Tienes "+total+ " objetos disponibles");
                    boolean correcto=true;
                    int cantidad;
                    do {
                        System.out.println("Quantos objetos desea borrar?");
                        try {
                            cantidad = Integer.parseInt(lector.nextLine());
                        } catch (NumberFormatException nfe) {
                            System.out.println("introduzca un numero por favor");
                            correcto=false;
                            cantidad=0;
                        }
                        if(cantidad<=total){
                            inventario.removeItem(item,cantidad);

                        }else{
                            System.out.println("No es una cantidad valida");
                        }
                    }while(!correcto || cantidad>total);
                }
            }

        }while(item!=null);
    }


    private static Item menuItems(){
        int opcion;
        Item item=null;
        do{
            System.out.println("Elije un item");
            System.out.println("1. Pico");
            System.out.println("2. Espada");
            System.out.println("3. Madera");
            System.out.println("4. Piedra");
            System.out.println("5. Huevo");
            System.out.println("6. Piedra de Ender");
            System.out.println("----------");
            System.out.println("0.Salir");

            try {
                opcion = Integer.parseInt(lector.nextLine());
            }catch (NumberFormatException nfe){
                opcion =-1;
            }
            if(opcion<0 || opcion>6){
                System.out.println("No correcto repita");
            }
        }while(opcion<0 || opcion>6);

        switch (opcion){
            case 1:
                item=new Pico();
                break;
            case 2:
                item=new Espada();
                break;
            case 3:
                item=new Madera();
                break;
            case 4:
                item=new Piedra();
                break;
            case 5:
                item=new Huevo();
                break;
            case 6:
                item=new PiedraDeEnder();
                break;
            case 0:
                item=null;
                break;

        }
        return item;
    }
}
