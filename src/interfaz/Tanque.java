package interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tanque {

    private ArrayList<JPanel> tanque;
    private int ancla;

    public ArrayList<JPanel> getTanque() {
        return tanque;
    }

    public void setTanque(ArrayList<JPanel> tanque) {
        this.tanque = tanque;
    }

    public int getAncla() {
        return ancla;
    }

    public void setAncla(int ancla) {
        this.ancla = ancla;
    }

    public void dibujarTanque(int putoReferencia, Direccion direccion, JPanel regilla) {
        desColorarDondeElTanqueEstuvo();
        ArrayList<JPanel> tankPartes = new ArrayList<JPanel>();
        int puntosAncla = putoReferencia;
        int puntosAux = putoReferencia;
        if (direccion == Direccion.Derecha) {
            for (int i = 1; i <= 11; i++) {
                JPanel tankPart = (JPanel) regilla.getComponent(puntosAux);
                tankPart.setBackground(Color.BLACK);
                tankPartes.add(tankPart);
                if (puntosAncla + 2 == puntosAux) {
                    puntosAux += 39;
                } else if (puntosAncla + 45 == puntosAux) {
                    puntosAux += 37;
                } else {
                    puntosAux += 1;
                }
            }
        } else if (direccion == Direccion.Izquierda) {
            System.out.println("Dibijando a la izquierda");
            for (int i = 1; i <= 11; i++) {
                if (puntosAux != 0) {
                    JPanel tankPart = (JPanel) regilla.getComponent(puntosAux);
                    tankPart.setBackground(Color.BLACK);
                    tankPartes.add(tankPart);
                    if (puntosAncla + 2 == puntosAux) {
                        puntosAux += 37;
                    } else if (puntosAncla + 43 == puntosAux) {
                        puntosAux += 39;
                    } else {
                        puntosAux += 1;
                    }
                }
            }
        } else if (direccion == Direccion.Arriba) {
            System.out.println("Dibijando a la Arriba");
            for (int i = 1; i <= 11; i++) {
                if (puntosAux != 0) {
                    JPanel tankPart = (JPanel) regilla.getComponent(puntosAux);
                    tankPart.setBackground(Color.BLACK);
                    tankPartes.add(tankPart);
                    //System.out.println("Punto[" + i + "]: puntosAncla [" + puntosAncla + "], puntosAux [" + puntosAux + "] DIFERENCIA [" + (puntosAncla - puntosAux) + "]");
                    if (puntosAncla + 2 == puntosAux) {
                        puntosAux -= 43;
                    } else if (puntosAncla - 39 == puntosAux) {
                        puntosAux -= 43;
                    } else if (puntosAncla - 80 == puntosAux) {
                        puntosAux -= 42;
                    } else if (puntosAncla - 122 == puntosAux) {
                        puntosAux -= 41;
                    } else {
                        puntosAux += 1;
                    }
                }
            }
        } else if (direccion == Direccion.Abajo) {
            System.out.println("Dibijando a la Abajo");
            for (int i = 1; i <= 11; i++) {
                if (puntosAux != 0) {
                    JPanel tankPart = (JPanel) regilla.getComponent(puntosAux);
                    tankPart.setBackground(Color.BLACK);
                    tankPartes.add(tankPart);
                    //System.out.println("Punto[" + i + "]: puntosAux [" + puntosAux + "], puntosAncla [" + puntosAncla + "] DIFERENCIA [" + (puntosAux - puntosAncla) + "]");
                    if (puntosAncla + 2 == puntosAux) {
                        puntosAux += 39;
                    } else if (puntosAncla + 43 == puntosAux) {
                        puntosAux += 39;
                    } else if (puntosAncla + 84 == puntosAux) {
                        puntosAux += 40;
                    } else if (puntosAncla + 124 == puntosAux) {
                        puntosAux += 41;
                    } else {
                        puntosAux += 1;
                    }
                }
            }
        }
        this.setTanque(tankPartes);
        this.setAncla(puntosAncla);

    }

    public void dibujarTanqueV2(int putoReferencia, Direccion direccion, JPanel regilla) {
        desColorarDondeElTanqueEstuvo();
        ArrayList<JPanel> tankPartes = new ArrayList<JPanel>();
        int puntosAncla = putoReferencia;
        int puntosAux = putoReferencia;
        if (direccion == Direccion.Derecha) {

        } else if (direccion == Direccion.Izquierda) {

        } else if (direccion == Direccion.Arriba) {

        } else if (direccion == Direccion.Abajo) {

        }
        this.setTanque(tankPartes);
        this.setAncla(puntosAncla);

    }

    public void desColorarDondeElTanqueEstuvo() {
        if (tanque != null) {
            for (int i = 0; i < tanque.size(); i++) {
                tanque.get(i).setBackground(Color.GRAY);
            }
        }
    }

}
