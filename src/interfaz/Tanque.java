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
    
}
