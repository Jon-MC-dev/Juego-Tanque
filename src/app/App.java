package app;

import interfaz.CampoBatalla;
import interfaz.Direccion;
import interfaz.Tanque;

public class App {

    public static void main(String[] args) {
        Tanque tanque = new Tanque();
        Thread hiloTanque = new Thread(tanque);
        CampoBatalla campo = new CampoBatalla(tanque);
        campo.setVisible(true);
        campo.setLocationRelativeTo(null);
        hiloTanque.run();
        System.out.println("Arrancamos el hilo");

        //campo.tanque.dibujarTanque(500, Direccion.Derecha, campo.regilla);
    }

}
