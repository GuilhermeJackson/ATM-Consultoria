package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.HTTTPService.HTTTPService;
import com.example.HTTTPService.MenuCEP;

public class MainActivity extends AppCompatActivity {
    private ImageView botaoEmpresa, botaoServicos, botaoClientes, botaoContatos;
    private TextView seekBarProject, putExtra, recycleView, dialog, etGroupRadion, txtToggleButton, txtMusica, txtSharedPrefe, txtArmazenamentoInterno, txtSQLite, txtHTTPService, txtRecyclerView;
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
        txtHTTPService = findViewById(R.id.txtHTTPService);
        txtRecyclerView = findViewById(R.id.txtRecyclerView);



        //zoom(botaoEmpresa);
        slideUp(botaoServicos);
        blink(botaoClientes);
        fade(botaoContatos);
        slidedown(botaoEmpresa);

        txtRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.example.RecycleViewAndJsonParsing.MainJsonParsing.class));
            }
        });

        txtHTTPService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MenuCEP.class));
            }
        });

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