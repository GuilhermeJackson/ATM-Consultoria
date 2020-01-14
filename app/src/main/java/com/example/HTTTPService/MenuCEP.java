package com.example.HTTTPService;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.atmempresadeconsultoria.R;

import java.util.concurrent.ExecutionException;

public class MenuCEP extends AppCompatActivity {
    Button botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cep);
        botao = findViewById(R.id.btnBuscarCEP);
        final TextView txtResposta = findViewById(R.id.txtExibir);
        final EditText etCep = findViewById(R.id.etCEP);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCep.getText().toString().length() > 0 && !etCep.getText().toString().equals("") && etCep.getText().toString().length() == 8) {
                    HTTTPService service = new HTTTPService(etCep.getText().toString());
                    try {
                        CEP retorno = service.execute().get();//o get() deve retorna o objeto definido na classe CEP
                        txtResposta.setText(retorno.toString());
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
