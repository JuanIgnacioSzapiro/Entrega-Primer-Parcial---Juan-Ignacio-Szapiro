package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Zona extends Lugar implements Serializable {
    private final ArrayList<Caja> cajas;

    public ArrayList<Caja> getCajas() {
        return cajas;
    }

    public Zona(int id, ArrayList<Usuario> usuarios, ArrayList<Caja> cajas) {
        super(id, usuarios);
        this.cajas = cajas;
    }
}
