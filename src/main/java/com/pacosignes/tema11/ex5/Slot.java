package com.pacosignes.tema11.ex5;

public class Slot {

    private boolean vacio;
    private int stack;

    private Item objeto;

    public Slot() {
        vacio=true;
        stack=0;
    }

    public boolean setItem(Item objeto){

        if(vacio=true) {
            this.objeto = objeto;
            return true;
        }else{
            return false;
        }
    }

    public int stackItem(int num){
        if(stack+num<objeto.getMaxStack()){
            stack=objeto.getMaxStack();
            return num-stack;
        }else{
            stack+=num;
            return 0;
        }
    }
    public int unstackItem(int num){
        stack-=num;
        if(stack<=0){
            stack=0;
            vacio=true;
        }
        return stack;
    }



}
