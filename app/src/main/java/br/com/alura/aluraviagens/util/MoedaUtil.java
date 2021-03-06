package br.com.alura.aluraviagens.util;

import android.support.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil
{

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    @NonNull
    public static String formataMoedaBrasileira(BigDecimal preco) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBrasileiro.format(preco).replace(FORMATO_PADRAO, FORMATO_COM_ESPACO);
    }
}
