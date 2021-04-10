package app;

import interfaz.CampoBatalla;
import interfaz.Direccion;

public class App {

    public static void main(String[] args) {
        CampoBatalla campo = new CampoBatalla();
        campo.setVisible(true);
        campo.dibujarTanque(500, Direccion.Derecha);
    }

}
