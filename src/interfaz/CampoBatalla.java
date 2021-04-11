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

    private Tanque tanque;
    private JPanel regilla;
    private ArrayList<JPanel> limitesLaterales;

    public CampoBatalla(Tanque tanque) {
        this.tanque = tanque;
        this.limitesLaterales = new ArrayList<JPanel>();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.regilla = new JPanel(new GridLayout(41, 41, 1, 1));
        JPanel panelGen;

        int paso = 0;
        for (int i = 0; i < 1681; i++) {
            panelGen = new JPanel();
            panelGen.setBackground(Color.GRAY);
            if (i <= 1000) {
                panelGen.add(new JLabel("" + i));
            }
            if (i % 41 == 0) {
                panelGen.setBackground(Color.BLUE);
                paso = i + 40;
                limitesLaterales.add(panelGen);
            }
            if (i == paso) {
                panelGen.setBackground(Color.RED);
                limitesLaterales.add(panelGen);
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                    tanque.dibujarTanqueV2(Direccion.Derecha, regilla, true);
                } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                    tanque.dibujarTanqueV2(Direccion.Izquierda, regilla, true);
                } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                    tanque.dibujarTanqueV2(Direccion.Arriba, regilla, true);
                } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                    tanque.dibujarTanqueV2(Direccion.Abajo, regilla, true);
                }
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    tanque.dibujarTanqueV2(tanque.getDireccionCanon(), regilla, false);
                    tanque.dispararProyectil();
                }
            }
        });
        System.out.println("Numero de componentes " + regilla.getComponentCount());
        this.getContentPane().add(regilla, BorderLayout.CENTER);
        this.setSize(500, 500);

        tanque.setAncla(800);
        tanque.setLimitesLaterales(limitesLaterales);
        tanque.dibujarTanqueV2(Direccion.Arriba, regilla, false);
    }

}
