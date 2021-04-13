package abstractos;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan_Morales
 */
public abstract class Obstaculo {

    private ArrayList<JPanel> puntosObstaculo; // Los puntos de los obstaculos
    private int puntoReferencia;
    protected JPanel campoBatalla;

    public Obstaculo(JPanel campoBatalla, int puntoReferencia) {
        this.campoBatalla = campoBatalla;
        this.puntoReferencia = puntoReferencia;
        this.dibujarEnCampoBatalla();

    }

    protected abstract ArrayList<JPanel> establecerForma(int puntoRef, ArrayList<JPanel> obstaculo);

    public void dibujarEnCampoBatalla() {
        this.puntosObstaculo = establecerForma(puntoReferencia, new ArrayList<JPanel>());
        this.pintarForma();
    }

    public void pintarForma() {
        for (int i = 0; i < puntosObstaculo.size(); i++) {
            puntosObstaculo.get(i).setBackground(Color.BLACK);
        }
    }

    public int getPuntoReferencia() {
        return puntoReferencia;
    }

    public void setPuntoReferencia(int puntoReferencia) {
        this.puntoReferencia = puntoReferencia;
    }

    public ArrayList<JPanel> getPuntosObstaculo() {
        return puntosObstaculo;
    }

}
