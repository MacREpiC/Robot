package org.iesalandalus.programacion.robot.modelo.personaje;

public enum Color{
    ROJO("Rojo"),
    VERDE("Verde"),
    AZUL("Azul");

    private String cadenaAMostrar;
    private Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
