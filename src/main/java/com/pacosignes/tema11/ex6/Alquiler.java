package com.pacosignes.tema11.ex6;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Alquiler implements Comparable<Alquiler>{

    private Alquilable alquilable;
    private GregorianCalendar fechaAlquiler;

    private GregorianCalendar fechaDevolucion;
    private float precioBase;
    private float recargo;

    public Alquiler(Alquilable alquilable, GregorianCalendar fechaAlquiler) {
        this.alquilable = alquilable;
        this.fechaAlquiler = fechaAlquiler;
        fechaDevolucion=null;
        precioBase=calcularPrecioBase();
        recargo=0;
    }

    /**
     * Comparador
     * @param alquiler
     * @return Devuelve menor que 0 si la fecha propia es anterior que la pasada por parametro
     *         Devuelve mayor que 0 si la fecha propia es posterior que la pasada por parametro
     *         Devuelve 0 si son iguales
     */
    public int compareTo(Alquiler alquiler){

        if(this.fechaAlquiler.before(alquiler.fechaAlquiler)){
            return 1;
        }else if(this.fechaAlquiler.after(alquiler.fechaAlquiler)){
            return -1;
        }else{
            return 0;
        }
    }

    public Alquilable getAlquilable() {
        return alquilable;
    }

    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        recargo=calcularRecargo(fechaDevolucion);

    }


    public float calcularPrecioBase(){
        if(alquilable.getMultimedia() instanceof Videojuego){
            if(alquilable.getMultimedia().getFechaEstreno().get(Calendar.YEAR)<Videoclub.DESCUENTO_ANYO_VIDEOJUEGOS){
                return Videoclub.PRECIO_BASE-1;
            }
        }else if(alquilable.getMultimedia() instanceof Pelicula){
            if(alquilable.getMultimedia().getFechaEstreno().get(Calendar.YEAR)<Videoclub.DESCUENTO_ANYO_PELICULAS){
                return Videoclub.PRECIO_BASE-1;
            }

        }else{
            return Videoclub.PRECIO_BASE;
        }

        return Videoclub.PRECIO_BASE;
    }

    public float calcularRecargo(GregorianCalendar fechaDevolucion){
        Date date1=fechaAlquiler.getTime();
        Date date2=fechaDevolucion.getTime();

        long ms=date1.getTime() - date2.getTime();
        int dias=(int) TimeUnit.DAYS.convert(ms,TimeUnit.MICROSECONDS);
        if(dias>Videoclub.PERIODO_ALQUILER) {
            return (dias -Videoclub.PERIODO_ALQUILER)*Videoclub.RECARGO_POR_DIA;
        }else{
            return 0;
        }
    }

    public void setAlquilable(Alquilable alquilable) {
        this.alquilable = alquilable;
    }

    @Override
    public String toString() {
        SimpleDateFormat fechaFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date date=fechaAlquiler.getTime();



        if(fechaDevolucion==null) {
            return "Alquiler{" +
                    "alquilable=" + alquilable +
                    ", fechaAlquiler=" + fechaFormat.format(date) +
                    ", precio base=" +precioBase +
                    "}\n";
        }else{
            Date date1=fechaDevolucion.getTime();
            return "Alquiler{" +
                    "alquilable=" + alquilable +
                    ", fechaAlquiler=" + fechaFormat.format(date) +
                    ", fechaDevolucion= " + fechaFormat.format(date) +
                    ", precio base=" + precioBase +
                    ", recargo=" +recargo +
                    "}\n";

        }
    }
}
