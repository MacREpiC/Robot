package org.iesalandalus.programacion.robot.modelo;

public class Consola {

    private Consola() {
        // Constructor privado para evitar la instanciación (clase de utilidad)
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Controlar un robot por defecto");
        System.out.println("2. Indicar zona");
        System.out.println("3. Indicar zona y orientación");
        System.out.println("4. Indicar zona, orientación y coordenada inicial");
        System.out.println("5. Ejecutar comando");
        System.out.println("6. Salir");
    }

    public static int elegirOpcion(int opcion) {
        if (opcion < 1 || opcion > 6) {
            throw new IllegalArgumentException("Opción inválida. Elige una opción del 1 al 6.");
        }
        return opcion;
    }

    public static Zona elegirZona(int ancho, int alto) {
        if (ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Ancho y alto deben ser mayores que cero.");
        }
        return new Zona(ancho, alto);
    }

    public
}
