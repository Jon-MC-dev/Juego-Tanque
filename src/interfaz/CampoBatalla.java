package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CampoBatalla extends JFrame {

    Tanque tanque;
    JPanel regilla;

    public CampoBatalla() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.regilla = new JPanel(new GridLayout(41, 41, 1, 1));
        JPanel panelGen;
        for (int i = 0; i < 1681; i++) {
            panelGen = new JPanel();
            System.out.println(i);
            panelGen.setBackground(Color.GRAY);
            if (i <= 1000) {
                panelGen.add(new JLabel("" + i));
            }
            panelGen.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent arg0) {
                    arg0.getComponent().setBackground(Color.BLACK);
                }

                public void mouseExited(MouseEvent arg0) {
                    arg0.getComponent().setBackground(Color.GRAY);
                }
            });
            regilla.add(panelGen, i);
        }
        this.setLayout(new BorderLayout());
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                System.out.println(evt.getKeyCode());
                if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dibujarTanque(tanque.getAncla() + 1, Direccion.Derecha);
                } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                    dibujarTanque(tanque.getAncla() - 1, Direccion.Izquierda);
                } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                    dibujarTanque(tanque.getAncla() - 41, Direccion.Arriba);
                } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                    dibujarTanque(tanque.getAncla() + 41, Direccion.Abajo);
                }
            }
        });
        System.out.println("Numero de componentes " + regilla.getComponentCount());
        this.getContentPane().add(regilla, BorderLayout.CENTER);
        this.setSize(500, 500);
    }

    public void dibujarTanque(int putoReferencia, Direccion direccion) {
        this.desColorarTodo();
        tanque = new Tanque();
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
                    System.out.println("Punto[" + i + "]: puntosAncla [" + puntosAncla + "], puntosAux [" + puntosAux + "] DIFERENCIA [" + (puntosAncla - puntosAux) + "]");
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
                    System.out.println("Punto[" + i + "]: puntosAux [" + puntosAux + "], puntosAncla [" + puntosAncla + "] DIFERENCIA [" + (puntosAux - puntosAncla) + "]");
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
        tanque.setTanque(tankPartes);
        tanque.setAncla(puntosAncla);

    }

    public void desColorarTodo() {
        for (int i = 0; i < regilla.getComponentCount(); i++) {
            regilla.getComponent(i).setBackground(Color.GRAY);
        }
    }
}
