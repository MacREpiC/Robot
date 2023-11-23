package org.iesalandalus.programacion.robot.modelo.personaje;

public record Posicion(int x, int y) {

    private static final int MIN_X = 0;
    private static final int MAX_X = 100;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 100;

    public Posicion {
        validarX(x);
        validarY(y);
    }

    public Posicion() {
        this(MIN_X, MIN_Y);
    }

    private void validarX(int x) {
        if (x < MIN_X) {
            throw new IllegalArgumentException("El valor de la x es menor que el mínimo permitido.");
        } else if (x > MAX_X) {
            throw new IllegalArgumentException("El valor de la x es mayor que el máximo permitido.");
        }
    }

    private void validarY(int y) {
        if (y < MIN_Y) {
            throw new IllegalArgumentException("El valor de la y es menor que el mínimo permitido.");
        } else if (y > MAX_Y) {
            throw new IllegalArgumentException("El valor de la y es mayor que el máximo permitido.");
        }
    }
}