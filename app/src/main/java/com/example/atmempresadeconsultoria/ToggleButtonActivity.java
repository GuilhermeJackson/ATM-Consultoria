package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity {
    private ToggleButton btToggleButton;
    private Button button;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        btToggleButton = findViewById(R.id.btToggleButton);
        button = findViewById(R.id.btToggleButton);
        texto = findViewById(R.id.txtToggle);

        btToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                texto.setText("Desligado! faz nada");
                if (isChecked) {
                    texto.setText("Ligo! faz alguma ação");
                }
            }
        });
    }
}
