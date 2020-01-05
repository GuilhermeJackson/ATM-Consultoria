package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Empresa2Activity extends AppCompatActivity {
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa2);

        texto = findViewById(R.id.texto);

        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            texto.setText(extra.getString("name"));
        }
    }
}
