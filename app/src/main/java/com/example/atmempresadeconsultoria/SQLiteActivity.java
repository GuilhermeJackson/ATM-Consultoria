package com.example.atmempresadeconsultoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.sqlite.SQLiteCursorCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SQLiteActivity extends AppCompatActivity {
    public EditText etTarefa;
    private Button btAdicionar;
    private ListView lvLista;
    private SQLiteDatabase bancoDeDados;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        try {
        etTarefa = findViewById(R.id.etTarefa);
        btAdicionar = findViewById(R.id.btAdicionar);

        bancoDeDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

        bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarefa = etTarefa.getText().toString().trim();
                salvarTarefa(tarefa);
            }
        });

            //Listar tarefas (exibir)
            recuperarTarefas();

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Item: ", position+"/" + ids.get(position));
                removerTarefa(ids.get(position));
            }
        });

        } catch (Exception e){
            e.printStackTrace();
        }
        //Listar tarefas (exibir)
        recuperarTarefas();

    }
    private void salvarTarefa(String texto){
        try {
            if (texto.equals("")){
                Toast.makeText(SQLiteActivity.this, "Digite uma tarefa!", Toast.LENGTH_SHORT).show();
            } else {
                bancoDeDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + texto + "') ");
                recuperarTarefas();
                etTarefa.setText("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recuperarTarefas() {
        try {
            //recuperar registros
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

            //recuperar id das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefas = cursor.getColumnIndex("tarefa");

            lvLista = findViewById(R.id.lvLista);

            //Criar adaptador
            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    itens);
            lvLista.setAdapter(itensAdaptador);

            //listar as tarefas
            cursor.moveToFirst();
            while(cursor != null) {
                Log.i("Resultado - ", "id tarefa: " + cursor.getString(indiceColunaId) + " Tarefa: " + cursor.getString((indiceColunaTarefas)));
                itens.add(cursor.getString(indiceColunaTarefas));
                ids.add(Integer.valueOf(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void removerTarefa(Integer id){
        try {
            bancoDeDados.execSQL("DELETE FROM tarefas WHERE id =" +id);
            recuperarTarefas();
            Toast.makeText(SQLiteActivity.this, "Tarefa removida com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

        /*

        try {
            SQLiteDatabase bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //.execSQL = usando para criar tabelas, inserir dados e remover dados
            //bancoDeDados.execSQL("DROP TABLE pessoas");
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            //inserindo dados na tabela //
            //bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Paulo', 30),('Antonio', 40)");

            //Altera a idade para 28 qualquer nome com a letra m
            //bancoDeDados.execSQL("UPDATE pessoa SET idade = 28 WHERE nome LIKE '%t%'");

            //Remover o nome Marco da tabela pessoa
            //bancoDeDados.execSQL("DELETE FROM pessoas WHERE nome = 'Palmeiras'");

            //Cursor permite correr os dados q foram inseridos  //rawQuery = percorre linha a linha
            //nome LIKE '%M%' = busca na coluna nome qualquer coisa antes do M e qualquer coisa depois do M
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM pessoas", null);


            //recuperar indice das colunas
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");

            //cursor após percorrer a coluna, ele é posicionado no último. moveToFirst() = move o cursor para a primeira posição
            cursor.moveToFirst();

            while(cursor != null){
                //getString recebe o indice da coluna

                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                Log.i("RESULTADO - id: ", cursor.getString(indiceColunaId));
                cursor.moveToNext();    //usado para o cursor nunca ser null enquanto ter alguma coisa
            }
        } catch (Exception e){
            e.printStackTrace();
        }
         */

