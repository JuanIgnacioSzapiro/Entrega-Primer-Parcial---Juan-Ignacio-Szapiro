package Control;
import Modelos.Administrador;
import Modelos.Usuario;
import Visual.EntradaSalida;
import Visual.Menu;

public class Sesion {
    /**
     * Crea sesión de usuario
     */
    public static Usuario crearSesion(){
        int opcion=0, contador=0;
        boolean exito = true;
        StringBuilder estado=new StringBuilder("");
        String nombreUsuario, clave;
        Archivo archivo = new Archivo();
        Usuario usuario=null;
        char tipo='A';
        EntradaSalida.mostrarString("CREACIÓN DE USUARIO:");
        try {
            archivo = archivo.deSerializar(Constantes.total);
            do {
                EntradaSalida.mostrarString("INGRESAR NOMBRE DE USUARIO: ");
                nombreUsuario = EntradaSalida.leerString();
            } while (Validacion.stringNull(nombreUsuario));
            do {
                EntradaSalida.mostrarString("INGRESAR CLAVE DE USUARIO: ");
                clave = EntradaSalida.leerString();
            } while (Validacion.stringNull(clave));
            opcion=Menu.seleccionTipo();
            switch (opcion){
                case 1:{
                    tipo='A';
                    break;
                }
                case 2:{
                    tipo='E';
                    break;
                }
                case 3:{
                    tipo='C';
                    break;
                }
            }
            try {
                usuario=archivo.buscarUsuario(nombreUsuario+":"+clave);
                //EntradaSalida.mostrarString("SIGUE");
            }catch (Exception exception){
                //EntradaSalida.mostrarString(exception.toString());
                EntradaSalida.mostrarString("HUBO UN ERROR EN LA BUSQUEDA DEL USUARIO");
            }
            //USUARIO TIENE QUE SER IGUAL A NULO PORQUE SIGNIFICA QUE NO EXISTE Y TIENE QUE SER ESCRITO
            if(usuario==null){
                try{
                    usuario=new Usuario(0, nombreUsuario, clave, tipo);
                    estado=new StringBuilder(archivo.buscarEstado(usuario));
                    if("".equals(estado.toString())){
                        try {
                            archivo.almacenarPendiente(usuario);
                            EntradaSalida.mostrarString("SE HA GUARDADO CON EXITO EL "+tipo);
                        }catch (Exception exception1){
                            //EntradaSalida.mostrarString(exception1.toString());
                            EntradaSalida.mostrarString("HUBO UN PROBLEMA CON LA ESCRITURA DEL ARCHIVO");
                        }
                    }
                    else {
                        EntradaSalida.mostrarString("EL USUARIO ESTA REGISTRADO Y EN ESTADO: "+estado);
                    }
                }catch (Exception exception){
                    EntradaSalida.mostrarString(exception.toString());
                    EntradaSalida.mostrarString("HUBO UN ERROR CON EL ALMACENAMIENTO");
                }
            }
            else {
                EntradaSalida.mostrarString("ESE USUARIO YA EXISTE");
            }
        } catch (Exception exception) {
            usuario=primeraSesion();
        }
        return usuario;
    }

    /**
     * Inicia la sesión
     */
    public static Usuario inicioSesion(){
        Archivo archivo = new Archivo();
        String nombreUsuario, clave;
        Usuario usuario=null;
        try {
            archivo = archivo.deSerializar(Constantes.total);
            do {
                EntradaSalida.mostrarString("INGRESAR NOMBRE DE USUARIO: ");
                nombreUsuario = EntradaSalida.leerString();
            } while (Validacion.stringNull(nombreUsuario));
            do {
                EntradaSalida.mostrarString("INGRESAR CLAVE DE USUARIO: ");
                clave = EntradaSalida.leerString();
            } while (Validacion.stringNull(clave));
            try {
                usuario=archivo.buscarUsuario(nombreUsuario+":"+clave);
            }catch (Exception exception1){
                EntradaSalida.mostrarString(exception1.toString());
                EntradaSalida.mostrarString("USUARIO NO ENCONTRADO");
            }
            if(usuario!=null){
                switch (usuario.getTipo()){
                    case 'A':{
                        EntradaSalida.mostrarString("SE HA INGRESADO CORRECAMENTE A LA SESIÓN COMO "+usuario.getNombreUsuario()+": ADMINISTRADOR");
                        break;
                    }
                    case 'E':{
                        EntradaSalida.mostrarString("SE HA INGRESADO CORRECAMENTE A LA SESIÓN COMO "+usuario.getNombreUsuario()+": EMPLEADO");
                        break;
                    }
                    case 'C':{
                        EntradaSalida.mostrarString("SE HA INGRESADO CORRECAMENTE A LA SESIÓN COMO "+usuario.getNombreUsuario()+": CLIENTE");
                        break;
                    }
                }
            }
            else {
                EntradaSalida.mostrarString("USUARIO NO ENCONTRADO");
            }
        } catch (Exception exception) {
            usuario=primeraSesion();
        }
        return usuario;
    }

    /**
     * Pasos para la creación del primer usuario/administrador/ra
     */
    public static Usuario primeraSesion() {
        Archivo archivo = new Archivo();
        Usuario usuario=null;
        String nombreUsuario, clave;
        EntradaSalida.mostrarString("INGRESO DE DATOS DEL PRIMER ADMINISTRADOR");
        do {
            EntradaSalida.mostrarString("INGRESAR NOMBRE DE USUARIO: ");
            nombreUsuario = EntradaSalida.leerString();
        } while (Validacion.stringNull(nombreUsuario));
        //EntradaSalida.mostrarString(nombreUsuario);
        do {
            EntradaSalida.mostrarString("INGRESAR CLAVE DE USUARIO: ");
            clave = EntradaSalida.leerString();
        } while (Validacion.stringNull(clave));
        //EntradaSalida.mostrarString(clave);
        archivo.getAdministradores().add(new Administrador(0, nombreUsuario, clave));
        archivo.getUsuarios().add(new Usuario(0, nombreUsuario, clave, 'A'));
        try {
            archivo.serializar(Constantes.total);
            EntradaSalida.mostrarString("SE HA GUARDADO CON ÉXITO EL ADMININISTRADOR");
        }catch (Exception exception1){
            EntradaSalida.mostrarString(exception1.toString());
            EntradaSalida.mostrarString("HUBO UN PROBLEMA CON LA ESCRITURA DEL ARCHIVO");
        }
        return new Usuario(0, nombreUsuario, clave, 'A');
    }
}