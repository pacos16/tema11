package com.pacosignes.tema11.ex5;



public class Inventario {


    private Slot[] inventario;

    /**
     * Constructor,
     * @param numSlots numero de slots del inventario
     *                 crea los objetos slot.
     */
    public Inventario(int numSlots) {
        this.inventario = new Slot[numSlots];

        for(int i=0;i<numSlots;i++){
            inventario[i]=new Slot();
        }
    }


    /**
     * Add item, el primer bulcle cumprueba si existen objetos para intentar stackear y insertarlos
     * el segundo bucle va creando rellenando slots vacios.
     * @param item
     * @param cantidad
     * @return devuelve el excedente que no cabe en el inventario
     */
    public int addItem(Item item, int cantidad){

            for(int i=0;i<inventario.length;i++){
                //bug into feature. si queda un madera entrara antes a ese que a otro. memoria de slot
                if(inventario[i].getItem()!=null && inventario[i].getItem().getClass().equals(item.getClass())){

                    cantidad=inventario[i].stackItem(cantidad);
                }
            }
            if(cantidad>0){
                for(int i=0;i<inventario.length && cantidad>0;i++){
                    if(inventario[i].getVacio()){
                        inventario[i].setItem(item);
                        cantidad=inventario[i].stackItem(cantidad);
                    }
                }
            }

        return cantidad;
    }





    public void printInventario(){
        for (Slot s: inventario
             ) {
            if(s.getVacio()){
                System.out.println("VACIO");
            }else {
                System.out.println(s.toString());
            }
        }
    }

    public int countItem(Item item){
        int sum=0;
        for (Slot s:inventario
             ) {
            if(s.getItem() != null && s.getItem().getClass().equals(item.getClass())){
                sum+=s.getStack();
            }
        }
        return sum;
    }
    public void removeItem(Item item, int cantidad){
        int resta;
        for (int i=0;i<inventario.length && cantidad>0;i++){
            if(inventario[i].getItem().getClass().equals((item.getClass()))){
                resta = cantidad - inventario[i].getStack();
                if(resta>=0){
                    cantidad-=inventario[i].getStack();
                    inventario[i].unstackItem(inventario[i].getStack());
               }else{
                    inventario[i].unstackItem(cantidad);
                    cantidad=0;
               }

            }
        }

    }





}
