package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmpresaActivity extends AppCompatActivity {
    private EditText etInfo;
    private Button passandoInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        etInfo = findViewById(R.id.etInfo);
        passandoInfo = findViewById(R.id.btnPassandoInfo);

        passandoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passandoInformacao = new Intent(EmpresaActivity.this, Empresa2Activity.class);
                passandoInformacao.putExtra("name", etInfo.getText().toString());
                startActivity(passandoInformacao);
            }
        });
    }
}
