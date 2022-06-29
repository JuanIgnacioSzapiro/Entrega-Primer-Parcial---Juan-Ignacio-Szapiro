package Visual;

import Control.Validacion;

public class Menu {
    /**
     * ES PARTE DE UNA VERIFICACION QUE PASAN TODOS LOS MENUES
     * @param mininmo VALOR MINIMO DEL MENU
     * @param maximo VALOR MAXIMO DEL MENU
     * @return VALOR LEIDO
     */
    public static int entradaMenu(int mininmo, int maximo){
        int opcion=0;
        boolean exito=false;
        do {
            do {
                try{
                    opcion= EntradaSalida.leerInt();
                    exito = true;
                }catch (Exception exception){
                    EntradaSalida.mostrarString(exception.toString());
                    EntradaSalida.mostrarString("INGRESAR NÚMEROS ENTEROS, ÚNICAMENTE");
                    exito=false;
                }
            }while (!exito);
        }while (!Validacion.valorEntre(opcion, mininmo, maximo));
        return opcion;
    }

    /**
     * MUESTRA EL MENU DE INICIO
     * @return OPCIÓN LEIDA
     */
    public static int menuInicio(){
        int opcion=0;
        EntradaSalida.mostrarString("MENU DE INICIO DE SESIÓN:\n\t1. INICIAR SESIÓN\n\t2. CREAR SESIÓN\n\t0. SALIR");
        opcion=entradaMenu(0,2);
        return opcion;
    }

    /**
     * MUESTRA EL MENU DE SELECCIÓN DE TIPO
     * @return OPCIÓN LEIDA
     */
    public static int seleccionTipo(){
        int opcion=0;
        EntradaSalida.mostrarString("ELEGIR EL TIPO DE USUARIO POR EL CUAL VA A REGISTRARSE:\n\t1. ADMINISTRADOR\n\t2. EMPLEADO\n\t3. CLIENTE");
        opcion=entradaMenu(0,3);
        return opcion;
    }
    /**
     *MUESTRA EL MENU DE ADMINISTRADOR
     * @return OPCIÓN LEIDA
     */
    public static int menuAdministrador(){
        int opcion=0;
        EntradaSalida.mostrarString("MENU ADMINISTRADOR:\n\t1. REGISTROS PENDIENTES\n\t2. REGISTROS APROBADOS\n\t3. REGISTROS RECHAZADOS\n\t4. EMPLEADOS\n\t5. CLIENTES\n\t6. SUCURSAL/ZONA/CAJA\n\t0. SALIR");
        opcion=entradaMenu(0,6);
        return opcion;
    }
    /**
     *MUESTRA EL MENU DE MODIFICACIONES DE PENDIENTES
     * @return OPCIÓN LEIDA
     */
    public static int menuPendientes(){
        int opcion=0;
        EntradaSalida.mostrarString("MENU PENDIENTES:\n\t1. APROBAR\n\t2. RECHAZAR\n\t0. SALIR");
        opcion=entradaMenu(0,2);
        return opcion;
    }

    /**
     * DA LA OPCIÓN DE TRABAJAR CON SUCURSAL/ZONA/CAJA
     * @return
     */
    public static int menuSucZonCaj(){
        int opcion=0;
        EntradaSalida.mostrarString("MENU SUCURSAL/ZONA/CAJA:\n\t1. AGREGAR\n\t2. REMOVER\n\t3. LISTAR TODO\n\t0. SALIR");
        opcion=entradaMenu(0,3);
        return opcion;
    }
    public static int menuAgregarLugar(){
        int opcion=0;
        EntradaSalida.mostrarString("MENU AGREGAR:\n\t1. SUCURSAL\n\t2. ZONA\n\t3. CAJA\n\t0. SALIR");
        opcion=entradaMenu(0,3);
        return opcion;
    }
    public static int menuRemoverLugar(){
        int opcion=0;
        EntradaSalida.mostrarString("MENU REMOVER:\n\t1. SUCURSAL\n\t2. ZONA\n\t3. CAJA\n\t0. SALIR");
        opcion=entradaMenu(0,3);
        return opcion;
    }
}