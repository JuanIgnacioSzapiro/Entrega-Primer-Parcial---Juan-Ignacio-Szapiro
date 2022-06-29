package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Lugar implements Serializable {
    private final int id;

    private final ArrayList<Usuario> usuarios;

    public int getId() {
        return id;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Lugar(int id, ArrayList<Usuario> usuarios) {
        this.id = id;
        this.usuarios = usuarios;
    }
}
