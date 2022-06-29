package Modelos;

import Control.Archivo;
import Control.Constantes;
import Visual.EntradaSalida;
import Visual.Menu;

import java.io.IOException;
import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
    public Administrador(int id, String nombreUsuario, String clave){
        super(id,  nombreUsuario,  clave, 'A');
        setId(id);
        setNombreUsuario(nombreUsuario);
        setClave(clave);
        setTipo('A');
    }

    /**
     * LISTA LOS PENDIENTES Y DESPLIEGA UN MENU QUE DA LAS ACCIONES QUE SE PUEDEN EJECUTAR CON EL LISTADO
     * @param archivo ARCHIVO PARA DESERIALIZAR Y SERIALIZAR
     * @param administrador ADMINISTRADOR QUE EJECUTA LA ACCIÓN
     */
    public static void listarRegistrosPendientes(Archivo archivo, Administrador administrador){
        int contador=0, opcion=-1;
        Usuario usuario=null;
        //EntradaSalida.mostrarString("ENTRA");
        //EntradaSalida.mostrarString("getPendientes.size()"+archivo.getPendientes().size());
        do {
            contador=0;
            if(archivo.getPendientes()!=null && archivo.getPendientes().size()!=0){
                EntradaSalida.mostrarString("POSICIÓN | NOMBRE DE USUARIO | TIPO DE USUARIO");
                while (contador<archivo.getPendientes().size()){
                    usuario=archivo.getPendientes().get(contador);
                    EntradaSalida.mostrarString(contador+" | "+usuario.getNombreUsuario()+" | "+usuario.getTipo());
                    contador++;
                }
                opcion=administrador.accionesPendientes(archivo);
            }
            else {
                EntradaSalida.mostrarString("LA LISTA DE PENDIENTES ESTA VACIA");
                opcion=0;
            }
        }while (opcion!=0);
    }

    /**
     * LISTA LOS APROBADOS
     * @param archivo ARCHIVO PARA DESERIALIZAR Y SERIALIZAR
     * @param administrador ADMINISTRADOR QUE EJECUTA LA ACCIÓN
     */
    public static void listarRegistrosAprobados(Archivo archivo, Administrador administrador){
        int contador=0;
        Usuario usuario=null;
        if(archivo.getAprobados()!=null && archivo.getAprobados().size()!=0){
            EntradaSalida.mostrarString("POSICIÓN | NOMBRE DE USUARIO | TIPO DE USUARIO");
            while (contador<archivo.getAprobados().size()){
                usuario=archivo.getAprobados().get(contador);
                EntradaSalida.mostrarString(contador+" | "+usuario.getNombreUsuario()+" | "+usuario.getTipo());
                contador++;
            }
        }
        else {
            EntradaSalida.mostrarString("LA LISTA DE APROBADOS ESTA VACIA");
        }
    }
    /**
     * LISTA LOS RECHAZADOS
     * @param archivo ARCHIVO PARA DESERIALIZAR Y SERIALIZAR
     * @param administrador ADMINISTRADOR QUE EJECUTA LA ACCIÓN
     */
    public static void listarRegistrosRechazados(Archivo archivo, Administrador administrador){
        int contador=0;
        Usuario usuario=null;
        if(archivo.getRechazados()!=null && archivo.getRechazados().size()!=0){
            EntradaSalida.mostrarString("POSICIÓN | NOMBRE DE USUARIO | TIPO DE USUARIO");
            while (contador<archivo.getRechazados().size()){
                usuario=archivo.getRechazados().get(contador);
                EntradaSalida.mostrarString(contador+" | "+usuario.getNombreUsuario()+" | "+usuario.getTipo());
                contador++;
            }
        }
        else {
            EntradaSalida.mostrarString("LA LISTA DE RECHAZADOS ESTA VACIA");
        }
    }

    /**
     * DESPLIEGA LAS ACCIONES QUE SE PUEDEN REALIZAR DESPUÉS DEL LISTADO DE PENDIENTES
     * @param archivo ARCHIVO PARA DESERIALIZAR Y SERIALIZAR
     */
    public static int accionesPendientes(Archivo archivo){
        int opcion=0, posicion=0;
        Usuario usuario;
        Administrador newAdmin;
        Empleado newEmpl;
        Cliente newCli;
        opcion=Menu.menuPendientes();
        switch (opcion){
            case 1:{
                EntradaSalida.mostrarString("INGRESAR LA POSICIÓN DEL USUARIO DESEADO A AROBAR");
                posicion = Menu.entradaMenu(0, archivo.getPendientes().size()-1);
                usuario=archivo.getPendientes().get(posicion);
                //AÑADIR FECHA DE INGRESO A APROBADOS
                usuario.setId(archivo.getUsuarios().size());
                archivo.getPendientes().remove(posicion);
                switch (usuario.getTipo()){
                    case 'A':{
                        newAdmin=new Administrador(usuario.getId(), usuario.getNombreUsuario(), usuario.getClave());
                        archivo.getAdministradores().add(newAdmin);
                        break;
                    }
                    case 'E':{
                        newEmpl=new Empleado(usuario.getId(), usuario.getNombreUsuario(), usuario.getClave());
                        archivo.getEmpleados().add(newEmpl);
                        break;
                    }
                    case 'C': {
                        //AÑADIR LA FECHA EN QUE SE INGRESÓ COMO CLIENTE
                        newCli = new Cliente(usuario.getId(), usuario.getNombreUsuario(), usuario.getClave());
                        archivo.getClientes().add(newCli);
                        break;
                    }
                }
                archivo.getAprobados().add(usuario);
                archivo.getUsuarios().add(usuario);
                break;
            }
            case 2:{
                EntradaSalida.mostrarString("INGRESAR LA POSICIÓN DEL USUARIO DESEADO A RECHAZAR");
                posicion = Menu.entradaMenu(0, archivo.getPendientes().size()-1);
                usuario=archivo.getPendientes().get(posicion);
                archivo.getRechazados().add(usuario);
                archivo.getPendientes().remove(posicion);
            }
            break;
        }
        try {
            archivo.serializar(Constantes.total);
            EntradaSalida.mostrarString("SE HA GUARDADO EN EL ARCHIVO PERFECTAMENTE");
        } catch (IOException e) {
            EntradaSalida.mostrarString("HUBO UN ERROR EN LA CARGA");
        }
    return opcion;
    }
    public void agregarSucursal(Archivo archivo){
        int max=0;
        Sucursal sucursal=null;
        try {
            archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarSucursal: "+exception);
        }
        if(archivo.getSucursales().size()!=0||archivo.getSucursales()!=null){
            max=buscarMaxIDSucursal(archivo);
            sucursal=new Sucursal(max+1, null, null);
        }
        else {
            sucursal=new Sucursal(0, null, null);
        }
        archivo.getSucursales().add(sucursal);
        try {
            archivo.serializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarSucursal: "+exception);
        }
    }
    public int buscarMaxIDSucursal(Archivo archivo){
        int max=0, contador=0;
        while (contador<archivo.getSucursales().size()){
            if(archivo.getSucursales().get(contador).getId()>max){
                max=archivo.getSucursales().get(contador).getId();
            }
            contador++;
        }
        return max;
    }
    public void agregarZona(Archivo archivo, Sucursal sucursal){
        int max=0;
        Zona zona=null;
        try {
            archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarZona: "+exception);
        }
        if(archivo.getZonas().size()!=0||archivo.getZonas()!=null){
            max=buscarMaxIDZona(archivo);
            zona=new Zona(max+1, null, null);
        }
        else {
            zona=new Zona(0, null, null);
        }
        archivo.getZonas().add(zona);
        sucursal.getZonas().add(zona);
        try {
            archivo.serializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarZona: "+exception);
        }
    }
    public int buscarMaxIDZona(Archivo archivo){
        int max=0, contador=0;
        while (contador<archivo.getZonas().size()){
            if(archivo.getZonas().get(contador).getId()>max){
                max=archivo.getZonas().get(contador).getId();
            }
            contador++;
        }
        return max;
    }
    public int buscarMaxIDZona(Sucursal sucursal){
        int max=0, contador=0;
        while (contador<sucursal.getZonas().size()){
            if(sucursal.getZonas().get(contador).getId()>max){
                max=sucursal.getZonas().get(contador).getId();
            }
            contador++;
        }
        return max;
    }
    public void agregarCaja(Archivo archivo, Zona zona){
        int max=0;
        Caja caja=null;
        try {
            archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarCaja: "+exception);
        }
        if(archivo.getCajas().size()!=0||archivo.getCajas()!=null){
            max=buscarMaxIDCaja(archivo);
            caja=new Caja(max+1, null);
        }
        else {
            caja=new Caja(0, null);
        }
        archivo.getCajas().add(caja);
        zona.getCajas().add(caja);
        try {
            archivo.serializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarCaja: "+exception);
        }
    }
    public int buscarMaxIDCaja(Archivo archivo){
        int max=0, contador=0;
        while (contador<archivo.getCajas().size()){
            if(archivo.getCajas().get(contador).getId()>max){
                max=archivo.getCajas().get(contador).getId();
            }
            contador++;
        }
        return max;
    }
    public void borrarSucursalr(Archivo archivo, Sucursal sucursal){
        int contador=0;
        Zona zona;
        try {
            archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarSucursal: "+exception);
        }
        while (contador<sucursal.getZonas().size()){
            zona=sucursal.getZonas().get(contador);
            borrarZona(archivo, zona);
            contador++;
        }
        archivo.getSucursales().remove(sucursal);
        try {
            archivo.serializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarSucursal: "+exception);
        }
    }
    public void borrarZona(Archivo archivo, Zona zona){
        int contador=0;
        Caja caja;
        try {
            archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarZona: "+exception);
        }
        while (contador<zona.getCajas().size()){
            caja=zona.getCajas().get(contador);
            borrarCaja(archivo, caja);
            contador++;
        }
        archivo.getZonas().remove(zona);
        try {
            archivo.serializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarZona: "+exception);
        }
    }
    public void borrarCaja(Archivo archivo, Caja caja){
        try {
            archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarCaja: "+exception);
        }
        archivo.getCajas().remove(caja);
        try {
            archivo.serializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("agregarCaja: "+exception);
        }
    }
}
