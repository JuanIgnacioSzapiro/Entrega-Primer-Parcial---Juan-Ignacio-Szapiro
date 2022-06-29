package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Sucursal extends Lugar implements Serializable {
    private final ArrayList<Zona> zonas;
    public ArrayList<Zona> getZonas() {
        return zonas;
    }
    public Sucursal(int id, ArrayList<Usuario> usuarios, ArrayList<Zona> zonas) {
        super(id, usuarios);
        this.zonas = zonas;
    }
}
