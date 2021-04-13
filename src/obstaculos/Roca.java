package obstaculos;

import abstractos.Obstaculo;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Roca extends Obstaculo {

    public Roca(JPanel campoBatalla, int puntoRef) {
        super(campoBatalla, puntoRef);
    }

    @Override
    protected ArrayList<JPanel> establecerForma(int puntoRef, ArrayList<JPanel> obstaculo) {
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 1));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 2));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 3));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 41));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 42));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 43));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 82));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 83));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 83));
        obstaculo.add((JPanel) campoBatalla.getComponent(puntoRef + 123));
        return obstaculo;
    }

}
