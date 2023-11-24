package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;

public class ControladorRobot {
    private Robot robot;

    public ControladorRobot(Robot robot) {
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {
        switch (comando) {
            case 'A' , 'a':
                try {
                    robot.avanzar();
                } catch (OperationNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 'D' , 'd':
                robot.girarALaDerecha();
                break;
            case 'I' , 'i':
                robot.girarALaIzquierda();
                break;
            default:
                throw new OperationNotSupportedException("Comando desconocido.");
        }
    }
}
