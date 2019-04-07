package com.pacosignes.tema11.ex6;

import java.util.GregorianCalendar;

public class Socio {
    private static int autoIncremento=0;
    private int idSocio;
    private String nombre;
    private String apellidos;
    private GregorianCalendar fechaNacimiento;

    public Socio(String nombre, String apellidos, GregorianCalendar fechaNacimiento) {
        autoIncremento++;
        idSocio=autoIncremento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    private Socio(int idSocio, String nombre, String apellidos, GregorianCalendar fechaNacimiento) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }
}
