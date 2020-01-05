package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {
    private  TextView txtExibir;
    private EditText etNome;
    private Button salvar, salvarFundo;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private ConstraintLayout relativeLayout;

    private static final String ARQUIVO_PREFERENCIA = "ARQUIVO PREFERENCIAS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        salvar = findViewById(R.id.imgSalvar);
        txtExibir = findViewById(R.id.txtExibirNome);
        etNome = findViewById(R.id.etNome);
        salvarFundo = findViewById(R.id.btSalvarFundo);
        radioGroup = findViewById(R.id.radioGroupFundo);
        relativeLayout = findViewById(R.id.layoutId);

        salvarFundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButton = radioGroup.getCheckedRadioButtonId();

                if (idRadioButton > 0) {
                    radioButtonSelecionado = findViewById(idRadioButton);
                    SharedPreferences sharedPreferencesCor = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sharedPreferencesCor.edit();
                    String corEscolhida  = radioButtonSelecionado.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();
                    setBackGround(corEscolhida);
                }
            }
        });

        //Recuperar os dados salvos ao abrir o app
        SharedPreferences sharedPreferencesCor = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //verifica se existe o "name" no sharedPreferences
        if(sharedPreferencesCor.contains("corEscolhida")) {
            //usuraio recebe o "name", ou por padrao "usuario nao definido"
            String corRecuperada = sharedPreferencesCor.getString("corEscolhida", "Laranja");
            setBackGround(corRecuperada);
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getSharedPreferences(nome do arquivo de preferencia, modo de leitura(0 = privado));
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                //Cria interface q permite editar o arquivo
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(etNome.getText().toString().equals("")) {
                    Toast.makeText(SharedPreferencesActivity.this, "Por favor, preencher o nome!", Toast.LENGTH_SHORT).show();
                } else {
                    //salvar a informação
                    editor.putString("name", etNome.getText().toString().trim());
                    //editor.commit(); - Confirma q a edição pode ser salva no arquivo
                    editor.commit();
                    txtExibir.setText("Olá " + etNome.getText().toString());
                }
            }
        });

        //Recuperar os dados salvos ao abrir o app
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //verifica se existe o "name" no sharedPreferences
        if(sharedPreferences.contains("name")) {
            //usuraio recebe o "name", ou por padrao "usuario nao definido"
            String usuario = sharedPreferences.getString("name", "usuario nao definido");
            txtExibir.setText("oi " + usuario);
        } else {
            txtExibir.setText("Olá usuario não definidpo");
        }
    }

    public void setBackGround(String cor) {
        if (cor.equals("Azul")) {
            relativeLayout.setBackgroundColor(Color.parseColor("#FF2734C2"));
        } else if (cor.equals("Laranja")){
            relativeLayout.setBackgroundColor(Color.parseColor("#ffce26"));
        } else if (cor.equals("Verde")){
            relativeLayout.setBackgroundColor(Color.parseColor("#009670"));
        }
    }
}
