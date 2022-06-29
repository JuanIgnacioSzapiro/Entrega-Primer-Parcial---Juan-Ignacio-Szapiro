package Modelos;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombreUsuario;
    private String clave;
    private char tipo;

    public int getId() {
        return id;
    }

    public char getTipo() {
        return tipo;
    }

    public Usuario(int id, String nombreUsuario, String clave, char tipo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
