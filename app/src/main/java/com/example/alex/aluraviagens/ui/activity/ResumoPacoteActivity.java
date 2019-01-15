package com.example.alex.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.aluraviagens.R;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

import static com.example.alex.aluraviagens.ui.activity.PacoteActivity.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do Pacote";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APP_BAR);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarDias(pacote);
        mostrarPreco(pacote);
        mostrarData(pacote);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }


    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostrarDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
