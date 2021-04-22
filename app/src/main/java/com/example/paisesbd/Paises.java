package com.example.paisesbd;

public class Paises {
   private int Id;
    private String Nombre;
    private Double Longitud;
    private Double Latitud;
    private int Poblacion;

    public Paises() {
    }



    public Paises(int id, String nombre, Double longitud, Double latitud, int poblacion) {
        Id = id;
        Nombre = nombre;
        Longitud = longitud;
        Latitud = latitud;
        Poblacion = poblacion;
    }


    @Override
    public String toString() {
        return "Paises{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Longitud=" + Longitud +
                ", Latitud=" + Latitud +
                ", Poblacion=" + Poblacion +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public int getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(int poblacion) {
        Poblacion = poblacion;
    }
}
