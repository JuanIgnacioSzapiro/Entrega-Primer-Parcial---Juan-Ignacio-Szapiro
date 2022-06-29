package Visual;
import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EntradaSalida {
    /**
     * IMPRIME POR TERMINAL EL MENSAJE
     * @param str MENSAJE A IMPRIMIR
     */
    public static void mostrarString(String str){
        System.out.println(str);
    }

    /**
     * LEE UNA CADENA INGRESADA POR TECLADO
     * @return RETORNA EL VALOR LEIDO
     * ACLARACIÓN: NO INCLUYE EXCEPTIONS
     */
    public static String leerString(){
        Scanner teclado=new Scanner(System.in);
        return teclado.nextLine();
    }

    /**
     *LEE UN ENTERO INGRESADO POR TECLADO
     * @return RETORNA EL VALOR LEIDO
     * ACLARACIÓN: NO INCLUYE EXCEPTIONS
     */
    public static int leerInt(){
        int entero=0;
        Scanner teclado=new Scanner(System.in);
        entero=teclado.nextInt();
        return entero;
    }
}
