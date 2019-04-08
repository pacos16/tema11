package com.pacosignes.tema11.ex6;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public String toString() {
        SimpleDateFormat fechaFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date date=fechaNacimiento.getTime();
        return "Socio{" +
                "idSocio=" + idSocio +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaFormat.format(date) +
                '}';
    }
}
