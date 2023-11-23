package org.iesalandalus.programacion.robot.modelo;

import com.sun.source.tree.CompilationUnitTree;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
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
        this.zona = zona;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion){
        this(zona);
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

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    public void avanzar() {
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
                nuevaX++;
            }
            case ESTE -> nuevaX++;
            case OESTE -> nuevaX--;
        }
    }
    public void girarALaDerecha(){
        switch (orientacion) {
            case ESTE -> setOrientacion(Orientacion.ESTE);
        }
    }
    public void girarALaIzquierda(){
        switch (orientacion) {
            case OESTE -> setOrientacion(Orientacion.OESTE);
        }
    }
}
