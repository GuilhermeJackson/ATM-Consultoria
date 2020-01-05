package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArmazenamentoInternoActivity extends AppCompatActivity {
    private EditText etTexto;
    private ImageView botaoSalvar;
    private static final String NOME_ARQUIVO = "arquivo_anotacao";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armazenamento_interno);

        etTexto = findViewById(R.id.etTexto);
        botaoSalvar = findViewById(R.id.imgSalvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = etTexto.getText().toString();
                gravarNoArquivo(textoDigitado);
                Toast.makeText(ArmazenamentoInternoActivity.this, "Texto armazenado internamente!!!", Toast.LENGTH_SHORT).show();
            }
        });

        //Recuperar o que foi gravado
        if( lerArquivo() != null) {
            etTexto.setText( lerArquivo() );
        }

    }
    private void gravarNoArquivo(String texto) {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(NOME_ARQUIVO, Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
        }catch (IOException e){         //IOException  - utilizado quando vai fazer operação de input ou output
            Log.v("Armazenamento", e.toString());
        }

    }

    private String lerArquivo() {
        String resultado = "";
        try {
            InputStream arquivo = openFileInput(NOME_ARQUIVO);
            if (arquivo != null) {

                //ler o arquivo
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);

                //Gerar buff do arquivo lido
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //Recuperar textos do arquivo
                String linhaArquivo ="";
                while ((linhaArquivo = bufferedReader.readLine()) != null){
                    resultado += linhaArquivo;
                }
                arquivo.close();
            }

        }catch (IOException e){
            Log.v("MainArmazenamento", e.toString());
        }

        return resultado;
    }
}
