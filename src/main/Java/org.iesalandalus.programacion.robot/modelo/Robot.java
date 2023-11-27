package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Enumeration;
import java.util.Objects;
public class Robot {
    private Coordenada coordenada;
    private Zona zona;
    private Orientacion orientacion;

    public Robot() {
        zona = new Zona();
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona) {
        this();
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion){
        this(zona);
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }
    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada){
        this(zona, orientacion);
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)){
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }
    public Robot(Robot robot){
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        zona = robot.zona;
        orientacion = robot.orientacion;
        coordenada = robot.coordenada;
    }
    public Zona getZona() {
        return zona;
    }
    public void setZona(Zona zona) {
        this.zona = Objects.requireNonNull(zona, "No puedo copiar una posición nula.");
    }
    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = Objects.requireNonNull(orientacion, "No puedo copiar una posición nula.");
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "No puedo copiar una posición nula.");
        if(!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
    }
    public void avanzar() throws OperationNotSupportedException {
        int nuevaX = getCoordenada().x();
        int nuevaY = getCoordenada().y();
        switch (orientacion){
            case NORTE -> nuevaY++;
            case NORESTE -> {
                nuevaY++;
                nuevaX++;
            }
            case NOROESTE -> {
                nuevaY++;
                nuevaX--;
            }
            case SUR -> nuevaY--;
            case SURESTE -> {
                nuevaY--;
                nuevaX++;
            }
            case SUROESTE -> {
                nuevaY--;
                nuevaX--;
            }
            case ESTE -> nuevaX++;
            case OESTE -> nuevaX--;
        }
        if (zona.pertenece(new Coordenada(nuevaX, nuevaY))){
            setCoordenada(new Coordenada(nuevaX, nuevaY));
        } else {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }
    }
    public void girarALaDerecha(){
        switch (orientacion) {
            case NORTE -> setOrientacion(Orientacion.NORESTE);
            case NORESTE -> setOrientacion(Orientacion.ESTE);
            case ESTE -> setOrientacion(Orientacion.SURESTE);
            case SURESTE -> setOrientacion(Orientacion.SUR);
            case SUR -> setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> setOrientacion(Orientacion.OESTE);
            case OESTE -> setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> setOrientacion(Orientacion.NORTE);
        }
    }
    public void girarALaIzquierda(){
        switch (orientacion) {
            case NORTE -> setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> setOrientacion(Orientacion.OESTE);
            case OESTE -> setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> setOrientacion(Orientacion.SUR);
            case SUR -> setOrientacion(Orientacion.SURESTE);
            case SURESTE -> setOrientacion(Orientacion.ESTE);
            case ESTE -> setOrientacion(Orientacion.NORESTE);
            case NORESTE -> setOrientacion(Orientacion.NORTE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordenada, robot.coordenada) && Objects.equals(zona, robot.zona) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, zona, orientacion);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordenada=" + coordenada +
                ", zona=" + zona +
                ", orientacion=" + orientacion +
                '}';
    }
}