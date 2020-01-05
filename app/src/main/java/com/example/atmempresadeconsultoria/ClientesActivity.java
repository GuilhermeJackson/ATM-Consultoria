package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ClientesActivity extends AppCompatActivity {
    private Button dialogId;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        dialogId = findViewById(R.id.dialogId);



        dialogId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cria alerta
                dialog = new AlertDialog.Builder(ClientesActivity.this);
                //configurar o titulo
                dialog.setTitle("Titulo do dialogo");
                //configura mensagem
                dialog.setMessage("Uma mensagem aleatória...");
                //configura se fecha o dialog quando clicado no fundo (false = nao fecha)
                dialog.setCancelable(false);
                //confira icone do lado do titulo
                dialog.setIcon(android.R.drawable.ic_delete);
                //botao negativo
                dialog.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ClientesActivity.this, "Pressionado botao nao", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ClientesActivity.this, "Pressionado botao sim", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();
            }
        });

    }
}
