package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

public class ServicosActivity extends AppCompatActivity {
    private RecyclerView listaItens;
    private String[] itens = {
            "Gaspar", "Ilhota", "BC Beach", "Floripa Beach", "Angola", "México", "Joinville", "Massaranduba", "Outra Cidade"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);
        listaItens= findViewById(R.id.recyclerView);
        slideUp(listaItens);

       // ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext());
    }

    public  void slideUp(View view){
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        listaItens.startAnimation(animation1);
    }
}
