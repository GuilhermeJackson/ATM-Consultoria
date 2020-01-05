package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ContatoActivity extends AppCompatActivity {
    private  SeekBar seekBar;
    private TextView exibir;
    private ImageView imgExibir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        seekBar = findViewById(R.id.seekBar);
        exibir = findViewById(R.id.exibirId);
        imgExibir = findViewById(R.id.imageExibe);

        // cria uma iterface com 3 metodos para monitorar o SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //metodo ao mover o SeekBar
                int valorProgress = progress;
                if(valorProgress <= 3){
                    imgExibir.setImageResource(R.drawable.pouco);
                } if(valorProgress >= 4) {
                    imgExibir.setImageResource(R.drawable.medio);
                } if (valorProgress >= 7) {
                    imgExibir.setImageResource(R.drawable.muito);
                } if (valorProgress >= 10) {
                    imgExibir.setImageResource(R.drawable.susto);
                }
                exibir.setText("Progresso: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //metodo ao pressionar o SeekBar
                Toast.makeText(ContatoActivity.this, "Pressionado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //metodo quando solta o SeekBar
                Toast.makeText(ContatoActivity.this, "Nao pressionado", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
