package interfaz;

public class Proyectil {

    private int puntoDeDisparo;

    public Proyectil(int puntoDeDisparo, boolean haSidoDisparado, Direccion direccionDisparo) {
        this.puntoDeDisparo = puntoDeDisparo;
        this.haSidoDisparado = haSidoDisparado;
        this.direccionDisparo = direccionDisparo;
    }
    private boolean haSidoDisparado;
    private Direccion direccionDisparo;
    

    public int getPuntoDeDisparo() {
        return puntoDeDisparo;
    }

    public void setPuntoDeDisparo(int puntoDeDisparo) {
        this.puntoDeDisparo = puntoDeDisparo;
    }

    public boolean haSidoDisparado() {
        return haSidoDisparado;
    }

    public void disparar() {
        this.haSidoDisparado = true;
    }

    public boolean isHaSidoDisparado() {
        return haSidoDisparado;
    }

    public void setHaSidoDisparado(boolean haSidoDisparado) {
        this.haSidoDisparado = haSidoDisparado;
    }

    public Direccion getDireccionDisparo() {
        return direccionDisparo;
    }

    public void setDireccionDisparo(Direccion direccionDisparo) {
        this.direccionDisparo = direccionDisparo;
    }

}
