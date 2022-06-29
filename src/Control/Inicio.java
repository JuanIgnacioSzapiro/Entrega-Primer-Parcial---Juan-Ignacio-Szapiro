package Control;

import Modelos.*;
import Visual.EntradaSalida;
import Visual.Menu;

import java.io.IOException;

public class Inicio {
    /**
     * Da comienzo al programa
     */
    public static void darComienzo() {
        int opcion=0;
        Usuario usuario=null;
        Administrador administrador=null;
        Empleado empleado=null;
        Cliente cliente=null;
        Archivo archivo=new Archivo();
        Sucursal sucursal;
        Zona zona;
        Caja caja;
            do {
                opcion = Menu.menuInicio();
                //EntradaSalida.mostrarString("SALE: "+opcion);
                switch (opcion) {
                    case 1: {
                        usuario = Sesion.inicioSesion();
                        if (usuario != null) {
                            try {
                                archivo = archivo.deSerializar(Constantes.total);
                            } catch (Exception exception) {
                                EntradaSalida.mostrarString("HUBO UN ERROR EN LA APERTURA DEL ARCHIVO");
                            }
                            switch (usuario.getTipo()) {
                                case 'A': {
                                    administrador = archivo.buscarAdministrador(usuario.getNombreUsuario() + ":" + usuario.getClave());
                                    do {
                                        opcion = Menu.menuAdministrador();
                                        switch (opcion) {
                                            case 0: {
                                                break;
                                            }
                                            case 1: {
                                                try {
                                                    administrador.listarRegistrosPendientes(archivo, administrador);
                                                } catch (Exception exception) {
                                                    EntradaSalida.mostrarString("listarRegistrosPendientes: " + exception.toString());
                                                }
                                                break;
                                            }
                                            case 2: {
                                                try {
                                                    administrador.listarRegistrosAprobados(archivo, administrador);
                                                } catch (Exception exception) {
                                                    EntradaSalida.mostrarString("listarRegistrosAprobados: " + exception.toString());
                                                }
                                                break;
                                            }
                                            case 3: {
                                                try {
                                                    administrador.listarRegistrosRechazados(archivo, administrador);
                                                } catch (Exception exception) {
                                                    EntradaSalida.mostrarString("listarRegistrosRechazados: " + exception.toString());
                                                }
                                                break;
                                            }
                                            case 4: {
                                                break;
                                            }
                                            case 5: {
                                                break;
                                            }
                                            case 6: {
                                                do{
                                                    opcion=Menu.menuSucZonCaj();
                                                    switch (opcion){
                                                        case 1: {
                                                            do {
                                                                opcion=Menu.menuAgregarLugar();
                                                                try {
                                                                    archivo=archivo.deSerializar(Constantes.total);
                                                                }catch (Exception exception){
                                                                    EntradaSalida.mostrarString("deSerializar: "+exception.toString());
                                                                }
                                                                switch (opcion){
                                                                    case 1: {
                                                                        try {
                                                                            archivo.listarSucursal(archivo);
                                                                            administrador.agregarSucursal(archivo);
                                                                        }catch (Exception exception){
                                                                            EntradaSalida.mostrarString("menuAgregarLugar, Sucursal: "+exception.toString());
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 2: {
                                                                        try {
                                                                            archivo.listarSucursal(archivo);
                                                                            EntradaSalida.mostrarString("ELEGIR DE LA LISTA ANTERIOR QUÉ SUCURSAL (SEGÚN SU ID) SE LE DESEA AGREGAR UNA ZONA");
                                                                            sucursal=archivo.getSucursales().get(Menu.entradaMenu(0,administrador.buscarMaxIDSucursal(archivo)));
                                                                            administrador.agregarZona(archivo, sucursal);
                                                                        }catch (Exception exception){
                                                                            EntradaSalida.mostrarString("menuAgregarLugar, Zona: "+exception.toString());
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        try {
                                                                            archivo.listarSucursal(archivo);
                                                                            EntradaSalida.mostrarString("ELEGIR DE LA LISTA ANTERIOR QUÉ SUCURSAL (SEGÚN SU ID) SE LE DESEA AGREGAR UNA CAJA");
                                                                            sucursal=archivo.getSucursales().get(Menu.entradaMenu(0,administrador.buscarMaxIDSucursal(archivo)));
                                                                            archivo.listarZonaDeSucursal(sucursal);
                                                                            EntradaSalida.mostrarString("ELEGIR DE LA LISTA ANTERIOR QUÉ ZONA (SEGÚN SU ID) SE LE DESEA AGREGAR UNA CAJA");
                                                                            zona=sucursal.getZonas().get(Menu.entradaMenu(0,administrador.buscarMaxIDZona(sucursal)));
                                                                            administrador.agregarCaja(archivo, zona);
                                                                        }catch (Exception exception){
                                                                            EntradaSalida.mostrarString("menuAgregarLugar, Caja: "+exception.toString());
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                            }while (opcion!=0);
                                                            opcion=-1;
                                                            break;
                                                        }
                                                        case 2: {
                                                            do {
                                                                opcion=Menu.menuRemoverLugar();
                                                                try {
                                                                    archivo=archivo.deSerializar(Constantes.total);
                                                                }catch (Exception exception){
                                                                    EntradaSalida.mostrarString("deSerializar: "+exception.toString());
                                                                }
                                                                switch (opcion){
                                                                    case 1: {
                                                                        try {
                                                                            archivo.listarSucursal(archivo);
                                                                            EntradaSalida.mostrarString("ELEGIR DE LA LISTA ANTERIOR QUÉ SUCURSAL (SEGÚN SU ID) SE BORRAR");
                                                                            sucursal=archivo.getSucursales().get(Menu.entradaMenu(0,administrador.buscarMaxIDSucursal(archivo)));
                                                                            administrador.borrarSucursalr(archivo, sucursal);
                                                                        }catch (Exception exception){
                                                                            EntradaSalida.mostrarString("borrarSucursalr, Sucursal: "+exception.toString());
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 2: {
                                                                        try {
                                                                            archivo.listarZona(archivo);
                                                                            EntradaSalida.mostrarString("ELEGIR DE LA LISTA ANTERIOR QUÉ ZONA (SEGÚN SU ID) SE BORRAR");
                                                                            zona=archivo.getZonas().get(Menu.entradaMenu(0,administrador.buscarMaxIDZona(archivo)));
                                                                            administrador.borrarZona(archivo, zona);
                                                                        }catch (Exception exception){
                                                                            EntradaSalida.mostrarString("borrarZona, Zona: "+exception.toString());
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        try {
                                                                            archivo.listarSucursal(archivo);
                                                                            EntradaSalida.mostrarString("ELEGIR DE LA LISTA ANTERIOR QUÉ CAJA (SEGÚN SU ID) SE DESEA BORRAR");
                                                                            caja=archivo.getCajas().get(Menu.entradaMenu(0,administrador.buscarMaxIDCaja(archivo)));
                                                                            administrador.borrarCaja(archivo, caja);
                                                                        }catch (Exception exception){
                                                                            EntradaSalida.mostrarString("menuAgregarLugar, Caja: "+exception.toString());
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                            }while (opcion!=0);
                                                            opcion=-1;
                                                            break;
                                                        }
                                                        case 3:{
                                                            archivo.listarSucursal(archivo);
                                                            archivo.listarZona(archivo);
                                                            archivo.listarCaja(archivo);
                                                        }
                                                    }
                                                }while (opcion!=0);
                                                opcion=-1;
                                                break;
                                            }
                                        }
                                    }while (opcion!=0);
                                    break;
                                }
                                case 'E': {
                                    empleado=archivo.buscarEmpleado(usuario.getNombreUsuario() + ":" + usuario.getClave());
                                    break;
                                }
                                case 'C': {
                                    cliente=archivo.buscarCliente(usuario.getNombreUsuario() + ":" + usuario.getClave());
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        Sesion.crearSesion();
                        break;
                    }
                }
        }while (opcion!=0);
    }
}