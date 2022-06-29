package Control;

import Modelos.*;
import Visual.EntradaSalida;

import java.io.*;
import java.util.ArrayList;

public class Archivo implements Serializable{
    private ArrayList<Usuario> usuarios=new ArrayList<>();
    private ArrayList<Administrador> administradores=new ArrayList<>();
    private ArrayList<Empleado> empleados=new ArrayList<>();
    private ArrayList<Cliente> clientes=new ArrayList<>();
    private ArrayList<Usuario>pendientes=new ArrayList<>();
    private ArrayList<Usuario>aprobados=new ArrayList<>();
    private ArrayList<Usuario>rechazados=new ArrayList<>();

    private ArrayList<Sucursal>sucursales=new ArrayList<>();

    private ArrayList<Zona>zonas=new ArrayList<>();
    private ArrayList<Caja> cajas=new ArrayList<>();

    public ArrayList<Usuario> getUsuarios() {return usuarios;}
    public void setUsuarios(ArrayList<Usuario> usuarios) {this.usuarios = usuarios;}
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Usuario> getPendientes() {
        return pendientes;
    }

    public void setPendientes(ArrayList<Usuario> pendientes) {
        this.pendientes = pendientes;
    }

    public ArrayList<Usuario> getAprobados() {
        return aprobados;
    }

    public void setAprobados(ArrayList<Usuario> aprobados) {
        this.aprobados = aprobados;
    }

    public ArrayList<Usuario> getRechazados() {
        return rechazados;
    }

    public void setRechazados(ArrayList<Usuario> rechazados) {
        this.rechazados = rechazados;
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(ArrayList<Zona> zonas) {
        this.zonas = zonas;
    }

    public ArrayList<Caja> getCajas() {
        return cajas;
    }

    public void setCajas(ArrayList<Caja> cajas) {
        this.cajas = cajas;
    }
    public Archivo() {
        usuarios=new ArrayList<Usuario>();
        administradores = new ArrayList<Administrador>();
        empleados = new ArrayList<Empleado>();
        clientes = new ArrayList<Cliente>();
        pendientes=new ArrayList<Usuario>();
        aprobados=new ArrayList<Usuario>();
        rechazados=new ArrayList<Usuario>();
        sucursales=new ArrayList<Sucursal>();
        zonas=new ArrayList<Zona>();
        cajas=new ArrayList<Caja>();
    }

    /**
     * LECTURA DE ARCHIVO DE OBJETOS
     * @param a ES EL NOMBRE DEL ARCHIVO A DESERIALIZAR
     * @return RETORNA EL ARCHIVO "ABIERTO"
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Archivo deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Archivo s = (Archivo) o.readObject();
        o.close();
        f.close();
        return s;
    }

    /**
     * ESCRITURA DE ARCHIVO DE OBJETOS
     * @param a ES EL NOMBRE DEL ARCHIVO SERIALIZAR
     * @throws IOException
     */
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    /**
     * BUSCA UN USUARIO PARTICULAR SEGÚN SU NOMBRE Y CLAVE
     * @param datos (obj.getNombreUsuario() + ":" + obj.getClave())
     * @return usuario encontrado o null
     */
    public Usuario buscarUsuario(String datos) {
        int contador = 0;
        Usuario us=null;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception){
            EntradaSalida.mostrarString("HUBO UN ERROR EN LA APERTURA DEL ARCHIVO");
        }
        while (contador < archivo.usuarios.size()) {
            //EntradaSalida.mostrarString("ENTRA");
            us = archivo.usuarios.get(contador);
            //EntradaSalida.mostrarString("nombreUsuario: "+us.getNombreUsuario()+"\nclave: "+us.getClave());
            if (datos.equals(us.getNombreUsuario() + ":" + us.getClave())) {
                return us;
            } else {
                contador++;
            }
        }
        return null;
    }

    /**
     * BUSCA UN ADMINISTRADOR PARTICULAR SEGÚN SU NOMBRE Y CLAVE
     * @param datos (obj.getNombreUsuario() + ":" + obj.getClave())
     * @return usuario encontrado o null
     */
    public Administrador buscarAdministrador(String datos) {
        int contador = 0;
        Administrador ad=null;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception){
            EntradaSalida.mostrarString("HUBO UN ERROR EN LA APERTURA DEL ARCHIVO");
        }
        while (contador < archivo.administradores.size()) {
            //EntradaSalida.mostrarString("ENTRA");
            ad = archivo.administradores.get(contador);
            //EntradaSalida.mostrarString("nombreUsuario: "+us.getNombreUsuario()+"\nclave: "+us.getClave());
            if (datos.equals(ad.getNombreUsuario() + ":" + ad.getClave())) {
                return ad;
            } else {
                contador++;
            }
        }
        return null;
    }

    /**
     * BUSCA EMPLEADO PARTICULAR SEGÚN SU NOMBRE Y CLAVE
     * @param datos(obj.getNombreUsuario() + ":" + obj.getClave())
     * @return usuario encontrado o null
     */
    public Empleado buscarEmpleado(String datos) {
        int contador = 0;
        Empleado empleado=null;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception){
            EntradaSalida.mostrarString("HUBO UN ERROR EN LA APERTURA DEL ARCHIVO");
        }
        while (contador < archivo.empleados.size()) {
            //EntradaSalida.mostrarString("ENTRA");
            empleado = archivo.empleados.get(contador);
            //EntradaSalida.mostrarString("nombreUsuario: "+us.getNombreUsuario()+"\nclave: "+us.getClave());
            if (datos.equals(empleado.getNombreUsuario() + ":" + empleado.getClave())) {
                return empleado;
            } else {
                contador++;
            }
        }
        return null;
    }

    /**
     * BUSCA CLIENTE PARTICULAR SEGÚN SU NOMBRE Y CLAVE
     * @param datos(obj.getNombreUsuario() + ":" + obj.getClave())
     * @return usuario encontrado o null
     */
    public Cliente buscarCliente(String datos) {
        int contador = 0;
        Cliente cliente=null;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception){
            EntradaSalida.mostrarString("HUBO UN ERROR EN LA APERTURA DEL ARCHIVO");
        }
        while (contador < archivo.clientes.size()) {
            //EntradaSalida.mostrarString("ENTRA");
            cliente = archivo.clientes.get(contador);
            //EntradaSalida.mostrarString("nombreUsuario: "+us.getNombreUsuario()+"\nclave: "+us.getClave());
            if (datos.equals(cliente.getNombreUsuario() + ":" + cliente.getClave())) {
                return cliente;
            } else {
                contador++;
            }
        }
        return null;
    }

    /**
     * BUSCA EL ESTADO DE UN USUARIO QUE ESTA REGISTRADO
     * @param us EL USUARIO DEL CUAL SE BUSCA EL ESTADO
     * @return RETORNA EL ESTADO
     */
    public String buscarEstado(Usuario us) {
        boolean encontradoPendiente = false, encontradoAprobado = false, encontradoRechazado = false;
        StringBuilder estado = new StringBuilder("");
        //EntradaSalida.mostrarString("us.getNombreUsuario() "+us.getNombreUsuario());
        try{
            encontradoPendiente = buscarPendiente(us);
        }catch (Exception exception){
            EntradaSalida.mostrarString(exception.toString());
            EntradaSalida.mostrarString("NO ENCONTRADO EN PENDIENTES");
        }
        try{
            encontradoAprobado = buscarAprobado(us);
        }catch (Exception exception){
            EntradaSalida.mostrarString(exception.toString());
            EntradaSalida.mostrarString("NO ENCONTRADO EN APROBADOS");
        }
        try{
            encontradoRechazado = buscarRechazado(us);
        }catch (Exception exception){
            EntradaSalida.mostrarString(exception.toString());
            EntradaSalida.mostrarString("NO ENCONTRADO EN RECHAZADOS");
        }
        if (encontradoPendiente) {
            estado = new StringBuilder("PENDIENTE");
        }
        else if (encontradoAprobado) {
            estado = new StringBuilder("APROBADO");
        }
        else if (encontradoRechazado) {
            estado = new StringBuilder("RECHAZADO");
        }
        return estado.toString();
    }

    /**
     * ALMACENAMIENTO EN PENDIENTES Y ESCRITURA DEL ARCHIVO
     * @param us EL USUARIO DEL CUAL SE QUIERE ALMACENAR
     */
    public void almacenarPendiente(Usuario us){
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("almacenarPendiente"+exception);
        }
        archivo.getPendientes().add(us);
        try {
            archivo.serializar(Constantes.total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * SE BUSCA UN USUARIO EN PEDIENTES
     * @param us USUARIO DEL QUE SE DESEA BUSCAR
     * @return RETORNA TRUE SI LO ENCUENTRA, FALSE EN CASO CONTRARIO
     */
    public boolean buscarPendiente(Usuario us){
        int contador_1=0;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("buscarPendiente"+exception);
        }
        try {
            if(archivo.getPendientes()==null){
                return false;
            }
            else {
                while ((contador_1 < archivo.getPendientes().size())) {
                    if (archivo.getPendientes().get(contador_1).getNombreUsuario().equals(us.getNombreUsuario())&&archivo.getPendientes().get(contador_1).getClave().equals(us.getClave())) {
                        return true;
                    }
                    contador_1++;
                }
            }
        }catch (Exception exception){
            EntradaSalida.mostrarString("buscarPendiente: "+exception);
        }
        return false;
    }

    /**
     * SE BUSCA UN USUARIO EN APROBADOS
     * @param us USUARIO DEL QUE SE DESEA BUSCAR
     * @return RETORNA TRUE SI LO ENCUENTRA, FALSE EN CASO CONTRARIO
     */
    public boolean buscarAprobado(Usuario us){
        int contador_1=0;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("buscarAprobado"+exception);
        }
        try {
            if(archivo.getAprobados()==null){
                return false;
            }
            else {
                while (contador_1<archivo.getAprobados().size()) {
                    if (archivo.getAprobados().get(contador_1).getNombreUsuario().equals(us.getNombreUsuario()) && archivo.getAprobados().get(contador_1).getClave().equals(us.getClave())) {
                        return true;
                    }
                    contador_1++;
                }
            }
        }catch (Exception exception){
            EntradaSalida.mostrarString("buscarAprobado: "+exception);
        }
        return false;
    }

    /**
     * SE BUSCA UN USUARIO EN RECHAZADOS
     * @param us USUARIO DEL QUE SE DESEA BUSCAR
     * @return RETORNA TRUE SI LO ENCUENTRA, FALSE EN CASO CONTRARIO
     */
    public boolean buscarRechazado(Usuario us){
        int contador_1=0;
        Archivo archivo=new Archivo();
        try {
            archivo=archivo.deSerializar(Constantes.total);
        } catch (Exception exception) {
            EntradaSalida.mostrarString("buscarRechazado"+exception);
        }
        try {
            if (archivo.getRechazados() == null) {
                return false;
            } else {
                while (contador_1 < archivo.getRechazados().size()) {
                    if (archivo.getRechazados().get(contador_1).getNombreUsuario().equals(us.getNombreUsuario()) && archivo.getRechazados().get(contador_1).getClave().equals(us.getClave())) {
                        return true;
                    }
                    contador_1++;
                }
            }
        }catch (Exception exception){
            EntradaSalida.mostrarString("buscarRechazado: "+exception);
        }
        return false;
    }

    /**
     * LISTA SUCURSAL
     * @param archivo
     */
    public void listarSucursal(Archivo archivo){
        int contador=0, contador1=0;
        Sucursal sucursal=null;
        if(archivo.getSucursales()!=null && archivo.getSucursales().size()!=0){
            EntradaSalida.mostrarString("SUCURSALES");
            while (contador<archivo.getSucursales().size()){
                sucursal=archivo.getSucursales().get(contador);
                EntradaSalida.mostrarString("\tPOSICIÓN SUCURSAL: "+contador+"\n\tZONAS PERTENECIENTES A LA SUCURSAL: ");
                while (contador1<sucursal.getZonas().size()) {
                    EntradaSalida.mostrarString("\t\tPOSICIÓN ZONA: "+contador1);
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO EMPLEADO:");
                while (contador1<sucursal.getUsuarios().size()) {
                    if(sucursal.getUsuarios().get(contador1).getTipo()=='E'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+sucursal.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+sucursal.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO CLIENTE:");
                while (contador1<sucursal.getUsuarios().size()) {
                    if(sucursal.getUsuarios().get(contador1).getTipo()=='C'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+sucursal.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+sucursal.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador++;
            }
        }
        else {
            EntradaSalida.mostrarString("LA LISTA DE SUCURSAL ESTA VACIA");
        }
    }

    /**
     * LISTA ZONAS
     * @param archivo
     */
    public void listarZona(Archivo archivo){
        int contador=0, contador1=0;
        Zona zona=null;
        if(archivo.getZonas()!=null && archivo.getZonas().size()!=0){
            EntradaSalida.mostrarString("ZONAS");
            while (contador<archivo.getZonas().size()){
                zona=archivo.getZonas().get(contador);
                EntradaSalida.mostrarString("\tPOSICION ZONA: "+contador+"\n\tCAJAS PERTENECIENTES A LA ZONA: ");
                while (contador1<zona.getCajas().size()) {
                    EntradaSalida.mostrarString("\t\tPOSICION CAJA: "+contador1);
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO EMPLEADO:");
                while (contador1<zona.getUsuarios().size()) {
                    if(zona.getUsuarios().get(contador1).getTipo()=='E'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+zona.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+zona.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO CLIENTE:");
                while (contador1<zona.getUsuarios().size()) {
                    if(zona.getUsuarios().get(contador1).getTipo()=='C'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+zona.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+zona.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador++;
            }
        }
        else {
            EntradaSalida.mostrarString("LA LISTA DE ZONAS ESTA VACIA");
        }
    }

    /**
     * LISTA ZONAS DE SUCURSAL PARTICULAR
     * @param sucursal
     */
    public void listarZonaDeSucursal(Sucursal sucursal){
        int contador=0, contador1=0;
        Zona zona=null;
        if(sucursal.getZonas()!=null && sucursal.getZonas().size()!=0){
            EntradaSalida.mostrarString("ZONAS");
            while (contador<sucursal.getZonas().size()){
                zona=sucursal.getZonas().get(contador);
                EntradaSalida.mostrarString("\tPOSICION ZONA: "+contador+"\n\tCAJAS PERTENECIENTES A LA ZONA: ");
                while (contador1<zona.getCajas().size()) {
                    EntradaSalida.mostrarString("\t\tPOSICION CAJA: "+contador1);
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO EMPLEADO:");
                while (contador1<zona.getUsuarios().size()) {
                    if(zona.getUsuarios().get(contador1).getTipo()=='E'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+zona.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+zona.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO CLIENTE:");
                while (contador1<zona.getUsuarios().size()) {
                    if(zona.getUsuarios().get(contador1).getTipo()=='C'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+zona.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+zona.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador++;
            }
        }
        else {
            EntradaSalida.mostrarString("LA LISTA DE ZONAS ESTA VACIA");
        }
    }

    /**
     * LISTA CAJAS
     * @param archivo
     */
    public void listarCaja(Archivo archivo){
        int contador=0, contador1=0;
        Caja caja=null;
        if(archivo.getZonas()!=null && archivo.getZonas().size()!=0){
            EntradaSalida.mostrarString("CAJAS");
            while (contador<archivo.getZonas().size()){
                caja=archivo.getCajas().get(contador);
                EntradaSalida.mostrarString("\tPOSICION CAJA: "+contador);
                EntradaSalida.mostrarString("\tUSUARIOS TIPO EMPLEADO:");
                while (contador1<caja.getUsuarios().size()) {
                    if(caja.getUsuarios().get(contador1).getTipo()=='E'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+caja.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+caja.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador1=0;
                EntradaSalida.mostrarString("\tUSUARIOS TIPO CLIENTE:");
                while (contador1<caja.getUsuarios().size()) {
                    if(caja.getUsuarios().get(contador1).getTipo()=='C'){
                        EntradaSalida.mostrarString("\t\tID USUARIO: "+caja.getUsuarios().get(contador1).getId()+"\n\t\tNOMBRE DE USUARIO: "+caja.getUsuarios().get(contador1).getNombreUsuario()+"\n\t\t");
                    }
                    contador1++;
                }
                contador++;
            }
        }
        else {
            EntradaSalida.mostrarString("LA LISTA DE CAJAS ESTA VACIA");
        }
    }
}