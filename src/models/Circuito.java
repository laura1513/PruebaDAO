package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Circuito {
    private String nombre;
    private int numero;
    private LocalDate fechaRace;

    public Circuito(String nombre, int numero, LocalDate fechaRace) {
        this.nombre = nombre;
        this.numero = numero;
        this.fechaRace = fechaRace;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public int getNumero() { return numero;}
    public LocalDate getFechaRace() { return fechaRace; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setFechaRace(LocalDate fechaRace) { this.fechaRace = fechaRace; }

    @Override
    public String toString() {
        return "Piloto{" +
                "nombre='" + nombre + '\'' +
                ", numero=" + numero +
                ", fechaRace=" + fechaRace.format(DateTimeFormatter.ofPattern("dd MMM yyyy")) +
                '}';
    }
}

