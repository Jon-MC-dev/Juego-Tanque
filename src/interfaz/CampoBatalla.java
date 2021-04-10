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
    public JPanel regilla;

    public CampoBatalla() {
        tanque = new Tanque();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.regilla = new JPanel(new GridLayout(41, 41, 1, 1));
        JPanel panelGen;
        for (int i = 0; i < 1681; i++) {
            panelGen = new JPanel();
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
                if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                    tanque.dibujarTanqueV2(Direccion.Derecha, regilla);
                } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                    tanque.dibujarTanqueV2(Direccion.Izquierda, regilla);
                } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
                    tanque.dibujarTanqueV2(Direccion.Arriba, regilla);
                } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                    tanque.dibujarTanqueV2(Direccion.Abajo, regilla);
                }
            }
        });
        System.out.println("Numero de componentes " + regilla.getComponentCount());
        this.getContentPane().add(regilla, BorderLayout.CENTER);
        this.setSize(500, 500);

        tanque.setAncla(499);
        tanque.dibujarTanqueV2(Direccion.Derecha, regilla);
    }

}
