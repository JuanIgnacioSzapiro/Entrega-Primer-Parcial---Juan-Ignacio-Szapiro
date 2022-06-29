package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Usuario implements Serializable {
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String especialidad;
    private ArrayList<Integer> idSucursal;
    private ArrayList<Integer> idZona;
    private ArrayList<Integer> idCaja;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Integer> getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(ArrayList<Integer> idSucursal) {
        this.idSucursal = idSucursal;
    }

    public ArrayList<Integer> getIdZona() {
        return idZona;
    }

    public void setIdZona(ArrayList<Integer> idZona) {
        this.idZona = idZona;
    }

    public ArrayList<Integer> getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(ArrayList<Integer> idCaja) {
        this.idCaja = idCaja;
    }

    public Empleado(int id, String nombreUsuario, String clave, char tipo, String codigo, String nombre, String direccion, String telefono, String especialidad, ArrayList<Integer> idSucursal, ArrayList<Integer> idZona, ArrayList<Integer> idCaja) {
        super(id, nombreUsuario, clave, tipo);
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.idSucursal = idSucursal;
        this.idZona = idZona;
        this.idCaja = idCaja;
    }

    public Empleado(int id, String nombreUsuario, String clave){
        super( id,  nombreUsuario,  clave, 'E');
        setId(id);
        setNombreUsuario(nombreUsuario);
        setClave(clave);
        setTipo('E');
    }
}
