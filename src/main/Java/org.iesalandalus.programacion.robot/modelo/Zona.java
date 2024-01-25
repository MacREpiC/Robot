package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;
import java.util.Random;

public record Zona(int ancho, int alto, Coordenada[] obstaculos) {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;
    public static final int MINIMO_OBTACULOS = 5;
    public static final int MAXIMO_OBSTACULOS = 10;

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
        validarObstaculo(obstaculos);
    }

    public Zona(int ancho, int alto) {
        this(ancho, alto, generarObstaculo());
    }

    private Coordenada[] generarObstaculo() {
        Random generador = new Random();
        int coordenadasAleatorias = generador.nextInt(MAXIMO_OBSTACULOS - MINIMO_OBTACULOS + 1) + MINIMO_OBTACULOS;
        Coordenada[] obstaculos = new Coordenada[coordenadasAleatorias];
        for (int i = 0; i < coordenadasAleatorias; i++) {
            int x = generador.nextInt(getAncho()) + 1;
            int y = generador.nextInt(getAlto()) + 1;
            obstaculos[i] = new Coordenada(x, y);
        }
        return obstaculos;
    }

    private void validarObstaculo(Coordenada[] obstaculos) {
        Objects.requireNonNull(obstaculos, "El obstáculo no puede ser nulo.");
    }
    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }
    private void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }
    public int getAncho(){
        return ancho;
    }
    public int getAlto(){
        return alto;
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return (perteneceX(coordenada.x()) && perteneceY(coordenada.y()));
    }

    private boolean perteneceX(int x) {
        return (ancho > x && x >= 0);
    }

    private boolean perteneceY(int y) {
        return (alto > y && y >= 0);
    }

    public boolean compararObstaculos(Coordenada coordenada, int i){
      return obstaculos[i].x() == coordenada.x() && obstaculos[i].y() == coordenada.y();
    }

    public boolean hayObstaculo(Coordenada coordenada){
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nulo");
        boolean ocupado=false;
        for(int i = 0; i < obstaculos.length && !ocupado; i++){
            if (compararObstaculos(coordenada, i))
                ocupado=true;
        }
        return ocupado;
    }
}