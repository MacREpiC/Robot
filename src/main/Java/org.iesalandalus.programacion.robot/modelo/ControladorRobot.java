package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;
import java.util.regex.Matcher;

public class ControladorRobot {
    private Robot robot;

    private static final String ER_CONTROLADOR = "[A|a|D|d|I|i]";

    public ControladorRobot(Robot robot) {
        Objects.requireNonNull(robot,"El robot no puede ser nulo.");
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(String comando) throws OperationNotSupportedException {
        if(comando.matches(ER_CONTROLADOR)){
            for(int i = 0; i < comando.length();i++){
                switch (comando.charAt(i)){
                    case 'A', 'a' -> robot.avanzar();
                    case 'D', 'd' -> robot.girarALaDerecha();
                    case 'I', 'i' -> robot.girarALaIzquierda();
                    default -> throw new OperationNotSupportedException("Comando desconocido.");
                }
            }
        }
    }
}