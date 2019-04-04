package com.pacosignes.tema11.ex6;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Main {


    public static void main(String[] args) {
        Faker faker= new Faker(new Locale("es"));

        
        System.out.println(faker.date().between());
    }
}
