package tanques;

import abstractos.Proyectil;
import abstractos.Direccion;
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
    private ArrayList<JPanel> limitesLaterales;

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
        desColorarDondeElTanqueEstuvo();
        ArrayList<JPanel> tankPartes = new ArrayList<JPanel>();
        int puntosAncla = this.ancla;
        if (mover) {
            if ((direccion == direccionCanon)) {
                puntosAncla = mover(direccion, this.ancla); // Aqui movemos el tanque
            }
        }
        this.direccionCanon = direccion;
        //System.out.println("Punto ancla " + puntosAncla);
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
        if (machLimitesAlMoverTanque(puntosAlMover)) {
            puntosAlMover = puntoActual;
        }
        return puntosAlMover;
    }

    private boolean machLimitesAlMoverTanque(int puntoPretendido) {
        boolean hayMach = false;
        // System.out.println("Punto pretendido [" + puntoPretendido + "]");
        // System.out.println("Cantidad de puntos limite " + limitesLaterales.size());
        for (int i = 0; i < limitesLaterales.size(); i++) {
            if (limitesLaterales.get(i).hashCode() == tanque.get(10).hashCode() || limitesLaterales.get(i).hashCode() == tanque.get(9).hashCode()) {
                //System.out.println("A la derecha ya no deveria pasar");
                hayMach = true;
            }

        }
        return hayMach;
    }

    private boolean machLimitesProyectil(Proyectil proyectil) {
        boolean hayMach = false;
        // System.out.println("Cantidad de puntos limite " + limitesLaterales.size());
        int hasPuntoDelProyectil = campoBatalla.getComponent(proyectil.getPuntoDeDisparo()).hashCode();
        for (int i = 0; i < limitesLaterales.size() && !hayMach; i++) {
            if (limitesLaterales.get(i).hashCode() == hasPuntoDelProyectil) {
                hayMach = true;
            }
        }
        return hayMach;
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
                if (10 == i) {
                    tanque.get(i).setBackground(Color.DARK_GRAY);

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
        int velocidad = 50;
        while (true) {
            try {
                // System.out.println("Actualmente hay " + posicionesProyectiles.size() + " proyectiles");
                Thread.sleep(velocidad);
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
                Thread.sleep(velocidad);
                // For para apagar los proyectiles
                for (int i = 0; i < posicionesProyectiles.size(); i++) {
                    Proyectil proyectil = posicionesProyectiles.get(i);
                    if (proyectil.haSidoDisparado()) {
                        try {
                            JPanel proyectilP = (JPanel) campoBatalla.getComponent(proyectil.getPuntoDeDisparo());
                            proyectilP.setBackground(Color.GRAY);
                            proyectil.setPuntoDeDisparo(mover(proyectil.getDireccionDisparo(), proyectil.getPuntoDeDisparo()));
                            if (machLimitesProyectil(proyectil)) {
                                posicionesProyectiles.remove(proyectil);
                            }
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

    public ArrayList<JPanel> getLimitesLaterales() {
        return limitesLaterales;
    }

    public void setLimitesLaterales(ArrayList<JPanel> limitesLaterales) {
        this.limitesLaterales = limitesLaterales;
    }

}
