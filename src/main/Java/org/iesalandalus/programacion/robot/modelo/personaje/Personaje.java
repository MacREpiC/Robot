package org.iesalandalus.programacion.robot.modelo.personaje;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Personaje {
    private String nombre;
    private int energia;
    private String color;
    private Posicion posicion;

    private static final int ENERGIA_INICIAL = 100;
    private static final int MAX_ENERGIA = 100;
    private static final int MIN_ENERGIA = 100;
    private static final String COLOR_INICIAL = "Verde";
    private static final String PREFIJO_NOMBRE = "Personaje ";

    private static int numPersonajes;

    public Personaje(){ //Constructor por defecto
        numPersonajes++;
        nombre = PREFIJO_NOMBRE + numPersonajes;
        color = COLOR_INICIAL;
        energia = ENERGIA_INICIAL;
        posicion = new Posicion();
    }
    public Personaje(String nombre) {
        this(); //Llamar al constructor por defecto
        setNombre(nombre);
    }
    public String getNombre() {
        return nombre;
    }
    public Personaje (String nombre, Posicion posicion){
        this(nombre);
        setPosicion(posicion);
    }
    public Personaje(String nombre, String color, Posicion posicion) {
        this(nombre, posicion);
        setColor(color);
    }
    public Personaje(String nombre, String color, int energia, Posicion posicion) {
        this(nombre,color, posicion);
        setEnergia(energia);
    }
    public Personaje(Personaje personaje){
        this(personaje.nombre, personaje.color, personaje.energia, personaje.posicion);
    }
    private void setNombre(String nombre){
        Objects.requireNonNull(nombre, "El nombre pasado es nulo.");
        this.nombre = nombre;
    }
    public void setColor(String color){
        Objects.requireNonNull(color, "El color pasado es nulo.");
        this.color = color;
    }
    private void setEnergia(int energia) {
        if (energia < MIN_ENERGIA) {
            throw new IllegalArgumentException("El valor de la energía no puede ser menor que el mínimo establecido.");
        } else if (energia > MAX_ENERGIA) {
            throw new IllegalArgumentException("El valor de la energía no puede ser mayor que el máximo establecido.");
        }
        this.energia = energia;
    }
    private void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }
    public String getColor(){
        return color;
    }
    public int getEnergia(){
        return energia;
    }
    public static int getNumPersonajes(){
        return numPersonajes;
    }
    public Posicion getPosicion(){
        return posicion;
    }
    public void chocar(int posiblePerdida) {
        energia -= posiblePerdida;
    }
    public void charlar(int posibleGanancia) {
        energia += posibleGanancia;
    }
    public void mover(int x, int y) throws OperationNotSupportedException {
        try {
            posicion = new Posicion(posicion.x() + x, posicion.y() + y);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("Movimiento no válido: " + e.getMessage());
        }
    }
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        Objects.requireNonNull(direccion, "La dirección no puede ser nula.");
        if (pasos <= 0) {
            throw new IllegalArgumentException("El número de pasos debe ser mayor que cero.");
        }
        int nuevaX = posicion.x();
        int nuevaY = posicion.y();
        switch (direccion) {
            case ARRIBA -> nuevaY += pasos;
            case ABAJO -> nuevaY -= pasos;
            case DERECHA -> nuevaX += pasos;
            case IZQUIERDA -> nuevaX -= pasos;
        }
        try {
            posicion = new Posicion(nuevaX, nuevaY);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("Movimiento no válido: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", color='" + color + '\'' +
                ", posicion=" + posicion +
                '}';
    }
}