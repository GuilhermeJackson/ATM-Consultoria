package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView botaoEmpresa, botaoServicos, botaoClientes, botaoContatos;
    private TextView seekBarProject, putExtra, recycleView, dialog, etGroupRadion, txtToggleButton, txtMusica, txtSharedPrefe, txtArmazenamentoInterno, txtSQLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoEmpresa = findViewById(R.id.empresaId);
        botaoServicos = findViewById(R.id.servicosId);
        botaoClientes = findViewById(R.id.clienteId);
        botaoContatos = findViewById(R.id.contatoId);
        seekBarProject = findViewById(R.id.seekBarProject);
        putExtra = findViewById(R.id.putExtra);
        recycleView = findViewById(R.id.recycleView);
        dialog = findViewById(R.id.dialog);
        txtToggleButton = findViewById(R.id.txtToggleButton);
        etGroupRadion = findViewById(R.id.etGroupRadion);
        txtMusica = findViewById(R.id.txtMusica);
        txtSharedPrefe = findViewById(R.id.txtSharedPrefe);
        txtArmazenamentoInterno = findViewById(R.id.txtArmazenamentoInterno);
        txtSQLite = findViewById(R.id.txtSQLite);

        //zoom(botaoEmpresa);
        slideUp(botaoServicos);
        blink(botaoClientes);
        fade(botaoContatos);
        slidedown(botaoEmpresa);

        txtSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SQLiteActivity.class));
            }
        });

        txtArmazenamentoInterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArmazenamentoInternoActivity.class));
            }
        });

        txtSharedPrefe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SharedPreferencesActivity.class));
            }
        });

        txtMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MusicaPlayActivity.class));
            }
        });

        txtToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ToggleButtonActivity.class));
            }
        });

        etGroupRadion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GroupRadionButtonActivity.class));
            }
        });

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClientesActivity.class));
            }
        });

        recycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServicosActivity.class));
            }
        });

        putExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this, EmpresaActivity.class)));
            }
        });

        seekBarProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });

        botaoEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this, EmpresaActivity.class)));
            }
        });

        botaoServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServicosActivity.class));
            }
        });

        botaoClientes.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClientesActivity.class));
            }
        }));

        botaoContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });
    }
    public  void zoom(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        botaoEmpresa.startAnimation(animation1);
    }

    public  void move(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        botaoServicos.startAnimation(animation1);
    }

    public  void blink(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        botaoClientes.startAnimation(animation1);
    }


    public  void slideUp(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        botaoServicos.startAnimation(animation1);
    }


    public  void fade(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        botaoContatos.startAnimation(animation1);
    }

    public  void slidedown(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        botaoEmpresa.startAnimation(animation1);
    }


}