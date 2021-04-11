package interfaz;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tanque implements Runnable {

    private ArrayList<JPanel> tanque;
    private int ancla;
    private ArrayList<Proyectil> posicionesProyectiles = new ArrayList<Proyectil>();
    private JPanel campoBatalla;
    private Proyectil ultimoProyectil;
    private Direccion direccionCanon;

    public Tanque() {

    }

    public Tanque(JPanel campo) {
        this.campoBatalla = campo;
    }

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

    public void dibujarTanqueV2(Direccion direccion, JPanel regilla, boolean mover) {
        this.campoBatalla = regilla;
        this.direccionCanon = direccion;
        desColorarDondeElTanqueEstuvo();
        ArrayList<JPanel> tankPartes = new ArrayList<JPanel>();
        int puntosAncla = this.ancla;
        if (mover) {
            puntosAncla = mover(direccion, this.ancla); // Aqui movemos el tanque
        }
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
            //ultimoProyectil = new Proyectil(puntosAux + 4, false, direccion);

        } else if (direccion == Direccion.Izquierda) {
            System.out.println("Mover a la Izquierda");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 2));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 3));
            //ultimoProyectil = new Proyectil(puntosAux - 4, false, direccion);

        } else if (direccion == Direccion.Arriba) {
            System.out.println("Mover a la Arriba");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 82));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux - 123));
            //ultimoProyectil = new Proyectil(puntosAux - 164, false, direccion);
        } else if (direccion == Direccion.Abajo) {
            System.out.println("Mover a la Abajo");
            tankPartes.add((JPanel) regilla.getComponent(puntosAux + 82));
            tankPartes.add((JPanel) regilla.getComponent(puntosAux + 123));
            //ultimoProyectil = new Proyectil(puntosAux + 164, false, direccion);
        }

        this.setTanque(tankPartes);
        this.colorearTanque();
        this.setAncla(puntosAncla);

    }

    private int mover(Direccion direccion, int puntoActual) {
        int puntosAlMover = 0;
        if (direccion == Direccion.Derecha) {
            puntosAlMover = puntoActual + 1;
        } else if (direccion == Direccion.Izquierda) {
            puntosAlMover = puntoActual - 1;
        } else if (direccion == Direccion.Arriba) {
            puntosAlMover = puntoActual - 41;
        } else if (direccion == Direccion.Abajo) {
            puntosAlMover = puntoActual + 41;
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

    public void dispararProyectil() {
        Proyectil proyectil = null;
        if (Direccion.Derecha == direccionCanon) {
            ultimoProyectil = new Proyectil(this.ancla + 4, false, direccionCanon);
        } else if (Direccion.Izquierda == direccionCanon) {
            ultimoProyectil = new Proyectil(this.ancla - 4, false, direccionCanon);
        } else if (Direccion.Arriba == direccionCanon) {
            ultimoProyectil = new Proyectil(this.ancla - 164, false, direccionCanon);
        } else if (Direccion.Abajo == direccionCanon) {
            ultimoProyectil = new Proyectil(this.ancla + 164, false, direccionCanon);
        }

        if (posicionesProyectiles.size() <= 3) {
            posicionesProyectiles.add(ultimoProyectil);
        }
        // # 
        for (int i = 0; i < posicionesProyectiles.size() && proyectil == null; i++) {
            if (!posicionesProyectiles.get(i).haSidoDisparado()) {
                proyectil = posicionesProyectiles.get(i);
            }
        }
        if (proyectil != null) {
            proyectil.disparar();
        }
    }

    @Override
    public void run() {
        System.out.println("Inicio del hilo");
        while (true) {
            try {
                System.out.println("Actualmente hay " + posicionesProyectiles.size() + " proyectiles");
                Thread.sleep(100);
                // For para encender los proyectiles
                for (int i = 0; i < posicionesProyectiles.size(); i++) {
                    Proyectil proyectil = posicionesProyectiles.get(i);
                    if (proyectil.haSidoDisparado()) {
                        try {
                            JPanel proyectilP = (JPanel) campoBatalla.getComponent(proyectil.getPuntoDeDisparo());
                            proyectilP.setBackground(Color.BLACK);
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Un proyectil se perdio en el vacio");
                            posicionesProyectiles.remove(proyectil);
                        }
                    }
                }
                Thread.sleep(100);
                // For para apagar los proyectiles
                for (int i = 0; i < posicionesProyectiles.size(); i++) {
                    Proyectil proyectil = posicionesProyectiles.get(i);
                    if (proyectil.haSidoDisparado()) {
                        try {
                            JPanel proyectilP = (JPanel) campoBatalla.getComponent(proyectil.getPuntoDeDisparo());
                            proyectilP.setBackground(Color.GRAY);
                            proyectil.setPuntoDeDisparo(mover(proyectil.getDireccionDisparo(), proyectil.getPuntoDeDisparo()));
                        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                            System.out.println("Un proyectil se perdio en el vacio");
                            posicionesProyectiles.remove(proyectil);
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                System.err.print("Hilo interrumpido");
            }
        }

    }

    public Direccion getDireccionCanon() {
        return direccionCanon;
    }

}
