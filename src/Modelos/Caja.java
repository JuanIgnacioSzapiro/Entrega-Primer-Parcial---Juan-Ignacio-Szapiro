package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Caja extends Lugar implements Serializable {
    public Caja(int id, ArrayList<Usuario> usuarios) {
        super(id, usuarios);
    }
}
