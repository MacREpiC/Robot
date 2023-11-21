package org.iesalandalus.programacion.robot.modelo;

import javax.management.openmbean.OpenDataException;
import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public record Zona(int ancho, int alto) {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }

    public Zona() {
        this(ANCHO_MINIMO, ANCHO_MINIMO);
    }

    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        } else if (ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }

    private void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        } else if (alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }
    private boolean perteneceX(int x){
        return ancho > x && x >= 0;
    }
    private boolean perteneceY(int y){
        return alto > y && y >= 0;
    }
}