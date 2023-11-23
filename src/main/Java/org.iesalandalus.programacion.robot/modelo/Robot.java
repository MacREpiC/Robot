package org.iesalandalus.programacion.robot.modelo;

import com.sun.source.tree.CompilationUnitTree;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
import java.awt.*;
import java.sql.RowId;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Set;

public class Robot {
    private Enumeration enumeration;
    //private ControladorRobot controladorRobot;
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
        Objects.requireNonNull(zona, "La orientación no puede ser un valor nulo.");
        this.zona = zona;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion){
        this(zona);
        Objects.requireNonNull(orientacion, "La orientación no puede ser un valor nulo.");
        this.orientacion = orientacion;
    }
    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada){
        this(zona, orientacion);
        this.coordenada = coordenada;
    }
    public Robot(Robot robot){
        zona = robot.zona;
        orientacion = robot.orientacion;
        coordenada = robot.coordenada;
    }
    public Zona getZona() {
        return zona;
    }
    public void setZona(Zona zona) {
        Objects.requireNonNull(zona, "No puedo copiar una posición nula.");
        this.zona = zona;
    }
    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "No puedo copiar una posición nula.");
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "No puedo copiar una posición nula.");
        if(zona.pertenece(coordenada)){
            this.coordenada = coordenada;
        } else{
            throw new IllegalArgumentException("Las coordenadas elegidas no son correctas");
        }
    }
    public void avanzar() {
        int nuevaX = 0;
        int nuevaY = 0;
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
        nuevaX *= getCoordenada().x();
        nuevaY *= getCoordenada().y();
        setCoordenada(new Coordenada(nuevaX, nuevaY));
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
        return Objects.equals(enumeration, robot.enumeration) && Objects.equals(coordenada, robot.coordenada) && Objects.equals(zona, robot.zona) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumeration, coordenada, zona, orientacion);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "enumeration=" + enumeration +
                ", coordenada=" + coordenada +
                ", zona=" + zona +
                ", orientacion=" + orientacion +
                '}';
    }
}
