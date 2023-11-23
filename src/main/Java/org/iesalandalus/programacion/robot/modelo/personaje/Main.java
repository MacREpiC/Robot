package org.iesalandalus.programacion.robot.modelo.personaje;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        /*
        Posicion miPosicion = new Posicion();
        Posicion miSegundaPosicion;
        miPosicion.setX(3);
        miSegundaPosicion = new Posicion(miPosicion);
        System.out.println(miPosicion);
        miSegundaPosicion.setX(8);
        System.out.println(miPosicion);
        */
        System.out.println("-Primer personaje-");
        Personaje miPrimerPersonaje;
        miPrimerPersonaje = new Personaje();
        System.out.println(miPrimerPersonaje);
        miPrimerPersonaje.chocar(10);
        System.out.println("Por chocar ahora tienes " + miPrimerPersonaje.getEnergia() + " de energía.");

        System.out.println();

        System.out.println("-Segundo personaje-");
        Personaje miSegundoPersonaje;
        miSegundoPersonaje = new Personaje("Alejandro", new Posicion(8,9 ));
        System.out.println("Nombre: " + miSegundoPersonaje.getNombre());
        System.out.println(miSegundoPersonaje.getPosicion());
        System.out.println("Color: " + miSegundoPersonaje.getColor());
        System.out.println("Energía: " + miSegundoPersonaje.getEnergia());
        miSegundoPersonaje.charlar(10);
        System.out.println("Por charlar ahora tienes " + miSegundoPersonaje.getEnergia() + " de energía.");

        System.out.println();

        System.out.println("-Tercer personaje-");
        Personaje miTercerPersonaje;
        miTercerPersonaje = new Personaje("Mac", "Rosa", new Posicion());
        System.out.println("Nombre: " + miTercerPersonaje.getNombre());
        System.out.println(miTercerPersonaje.getPosicion());
        System.out.println("Color: " + miTercerPersonaje.getColor());
        System.out.println("Energía: " + miTercerPersonaje.getEnergia());
        miTercerPersonaje.charlar(10);
        System.out.println("Por charlar ahora tienes " + miTercerPersonaje.getEnergia() + " de energía.");

        System.out.println();

        System.out.println("-Cuarto personaje-");
        Personaje miCuartoPersonaje;
        miCuartoPersonaje = new Personaje("Mac", "Amarillo", 90, new Posicion(5, 9));
        System.out.println("Nombre: " + miCuartoPersonaje.getNombre());
        System.out.println(miCuartoPersonaje.getPosicion());
        System.out.println("Color: " + miCuartoPersonaje.getColor());
        System.out.println("Energía: " + miCuartoPersonaje.getEnergia());
        miCuartoPersonaje.charlar(10);
        System.out.println("Por charlar ahora tienes " + miCuartoPersonaje.getEnergia() + " de energía.");

        System.out.println();

        System.out.println();
        System.out.println("-Copia personaje-");
        Personaje miPersonajeCopia;
        miPersonajeCopia = new Personaje(miTercerPersonaje);
        System.out.println("Nombre: " + miPersonajeCopia.getNombre());
        System.out.println(miPersonajeCopia.getPosicion());
        System.out.println("Color: " + miPersonajeCopia.getColor());
        System.out.println("Energía: " + miPersonajeCopia.getEnergia());
        System.out.println("Esto es una copia de tercer personaje por comerte una seta.");

        System.out.println();

        System.out.println("-Quinto personaje-");
        Personaje miQuintoPersonaje;
        miQuintoPersonaje = new Personaje();
        System.out.println(miQuintoPersonaje);
        miQuintoPersonaje.chocar(10);
        System.out.println("Por chocar ahora tienes " + miQuintoPersonaje.getEnergia() + " de energía.");

        System.out.println();
    }
}
