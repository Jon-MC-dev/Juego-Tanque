package interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tanque{

    private ArrayList<JPanel> tanque;
    private int ancla;
    private JPanel proyectil;
    private Direccion orientacion;

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

    public void dibujarTanqueV2(Direccion direccion, JPanel regilla) {
        this.orientacion = direccion;
        desColorarDondeElTanqueEstuvo();
        ArrayList<JPanel> tankPartes = new ArrayList<JPanel>();
        int puntosAncla = mover(direccion); // Aqui movemos el tanque
        System.out.println("Punto ancla " + puntosAncla);
        int puntosAux = puntosAncla;
        tankPartes.add((JPanel) regilla.getComponent(puntosAux - 42));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux - 41));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux - 40));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux - 1));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux + 1));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux + 40));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux + 41));
        tankPartes.add((JPanel) regilla.getComponent(puntosAux + 42));
        if (direccion == Direccion.Derecha) {
            System.out.println("Mover a la derecha");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux + 2));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux + 3));
            proyectil = (JPanel) regilla.getComponent(puntosAux + 4);

        } else if (direccion == Direccion.Izquierda) {
            System.out.println("Mover a la Izquierda");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 2));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 3));
        } else if (direccion == Direccion.Arriba) {
            System.out.println("Mover a la Arriba");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 82));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 123));
            proyectil = (JPanel) regilla.getComponent(puntosAux - 123);

        } else if (direccion == Direccion.Abajo) {
            System.out.println("Mover a la Abajo");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux + 82));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux + 123));

        }
        this.setTanque(tankPartes);
        this.colorearTanque();
        this.setAncla(puntosAncla);

    }

    public int mover(Direccion direccion) {
        int puntosAlMover = 0;
        if (direccion == Direccion.Derecha) {
            puntosAlMover = this.ancla + 1;
        } else if (direccion == Direccion.Izquierda) {
            puntosAlMover = this.ancla - 1;
        } else if (direccion == Direccion.Arriba) {
            puntosAlMover = this.ancla - 41;
        } else if (direccion == Direccion.Abajo) {
            puntosAlMover = this.ancla + 41;
        }
        return puntosAlMover;
    }

    public void desColorarDondeElTanqueEstuvo() {
        if (tanque != null) {
            for (int i = 0; i < tanque.size(); i++) {
                tanque.get(i).setBackground(Color.GRAY);
            }
        }
    }

    public void colorearTanque() {
        if (tanque != null) {
            for (int i = 0; i < tanque.size(); i++) {
                tanque.get(i).setBackground(Color.BLACK);
                if (4 == i) {
                    tanque.get(i).setBackground(Color.RED);
                }
            }
        }
    }
    

    public void disparar() {
        System.out.println("Vamos a disparar WE");
        while (true) {
            try {
                proyectil.setBackground(Color.BLUE);
                Thread.sleep(1000);
                proyectil.setBackground(Color.GRAY);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }

    }

}
