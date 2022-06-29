package Control;

import Visual.EntradaSalida;

public class Validacion {
    /**
     *
     * @param numero numero a evaluar
     * @param min valor mínimo a comparar
     * @param max valor máximo a comparar
     * @return 'true' si está entre los valores/'false' si está por fuera
     */
    public static boolean valorEntre(int numero, int min, int max){
        if(numero<min||numero>max){
            EntradaSalida.mostrarString("EL VALOR DEBE ESTAR ENTRE "+min+" Y "+max);
            return false;
        }
        //EntradaSalida.mostrarString(numero+"<"+min+"||"+numero+">"+max+exito);
        return true;
    }
    /**
     * Valida que un "String" no sea 'NULL'
     * @param str "String" a analizar
     * @return 'false' "String" NO nulo/'true' "String" nulo
     */
    public static boolean stringNull(String str){
        boolean exito=false;
        if(str.equals("")){
            EntradaSalida.mostrarString("NO PUEDE SER NULO");
            exito= true;
        }
        return exito;
    }
}