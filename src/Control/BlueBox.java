package Control;

import Visual.EntradaSalida;

public class BlueBox {
    public static void main(String[] args) {
        EntradaSalida.mostrarString("COMIENZO DEL PROGRAMA");
        try {
            Inicio.darComienzo();
        }catch (Exception e){
            EntradaSalida.mostrarString(e.toString());
            EntradaSalida.mostrarString("HUBO UN ERROR FATAL EN EL PROGRAMA");
        }
        EntradaSalida.mostrarString("FIN DEL PROGRAMA");
    }
}
