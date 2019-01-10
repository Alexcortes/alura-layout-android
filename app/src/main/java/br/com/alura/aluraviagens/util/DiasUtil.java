package br.com.alura.aluraviagens.util;
import android.support.annotation.NonNull;


public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataDiasEmTexto(int numeroDias) {
        if(numeroDias > 1){
            return  numeroDias + PLURAL;
        }
        return numeroDias + SINGULAR;
    }

}
