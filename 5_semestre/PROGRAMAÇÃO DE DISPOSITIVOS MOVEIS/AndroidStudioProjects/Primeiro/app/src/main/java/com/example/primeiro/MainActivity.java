package com.example.primeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    TextView resposta;

    ListView lista;
    ArrayAdapter adapter;
    int soma = 0;
    ArrayList<Integer> numeros;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = (EditText) findViewById(R.id.editor);
        resposta =(TextView) findViewById(R.id.resposta);
        lista = (ListView)  findViewById(R.id.lista);


        if (savedInstanceState != null){
            soma = savedInstanceState.getInt("soma_atual",0);
            resposta.setText("Resposta: " + soma);
            numeros = savedInstanceState.getIntegerArrayList("lista_numeros");

        }
        if (numeros == null){

            numeros = new ArrayList<>();

        }
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_multiple_choice, numeros);
        lista.setAdapter(adapter);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public void somar(View btn){

        try {

            String text = entrada.getText().toString();
            int valor = Integer.parseInt(text);
            soma += valor;
            numeros.add(valor);
            resposta.setText("resposta: " + soma);
            entrada.setText("");
            adapter.notifyDataSetChanged();

        }catch (Throwable t){
            Toast.makeText(this, "Informe um número a somar", Toast.LENGTH_SHORT).show();
        }
        
    }

    public void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putInt("soma_atual", soma);
        dados.putIntegerArrayList("lista_numeros", numeros);

    }
    public void remover(View btn){
        /* remover quando modo de seleção for single choice
      int posicao = lista.getCheckedItemPosition();
      if (posicao < 0){
          Toast.makeText(this, "SSelecione um numero para remover!", Toast.LENGTH_SHORT).show();
      }else {
          Integer val = numeros.remove(posicao);
          soma -= val;
          resposta.setText("Resposta: " + soma );
          adapter.notifyDataSetChanged();
          lista.clearChoices();
      }

         */
        //QUANDO O MODO FOR MULTIPLE
        int cont = lista.getCheckedItemCount();
        if (cont > 0){
            SparseBooleanArray sels = lista.getCheckedItemPositions();
            ArrayList<Integer> aReemover = new ArrayList<>(cont);
            for(int i = 0; i < numeros.size(); i++){
                if (sels.get(i)){
                    aReemover.add(numeros.get(i));
                    soma -= numeros.get(i);
                }
            }
            numeros.removeAll(aReemover);
            resposta.setText("Resposta: " + soma );
            adapter.notifyDataSetChanged();
            lista.clearChoices();

        }
    }


}

















