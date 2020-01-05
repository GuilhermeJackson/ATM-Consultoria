package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GroupRadionButtonActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radionButton;
    private Button escolher;
    private TextView exibir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_radion_button);
        radioGroup = findViewById(R.id.radioGroup);
        escolher = findViewById(R.id.escolher);
        exibir = findViewById(R.id.exibindoRadio);

        escolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                if (idRadioButtonEscolhido >0) {
                    radionButton = findViewById(idRadioButtonEscolhido);
                    exibir.setText(radionButton.getText());
                }
            }
        });

    }
}
