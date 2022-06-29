package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Usuario implements Serializable {
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;
    private String email;
    private String fechaInicio;
    private ArrayList<Integer> idSucursal;
    private ArrayList<Integer> idZona;
    private ArrayList<Integer> idCaja;

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public ArrayList<Integer> getIdSucursal() {
        return idSucursal;
    }

    public ArrayList<Integer> getIdZona() {
        return idZona;
    }

    public ArrayList<Integer> getIdCaja() {
        return idCaja;
    }
    public Cliente(int id, String nombreUsuario, String clave, char tipo, String nombre, String direccion, String dni, String telefono, String email, String fechaInicio, ArrayList<Integer> idSucursal, ArrayList<Integer> idZona, ArrayList<Integer> idCaja) {
        super(id, nombreUsuario, clave, tipo);
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaInicio = fechaInicio;
        this.idSucursal = idSucursal;
        this.idZona = idZona;
        this.idCaja = idCaja;
    }
    public Cliente(int id, String nombreUsuario, String clave){
        super( id,  nombreUsuario,  clave, 'C');
        setId(id);
        setNombreUsuario(nombreUsuario);
        setClave(clave);
        setTipo('C');
    }
}
