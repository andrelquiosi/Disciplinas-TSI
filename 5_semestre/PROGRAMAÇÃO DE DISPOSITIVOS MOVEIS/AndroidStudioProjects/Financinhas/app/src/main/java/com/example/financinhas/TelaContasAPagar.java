package com.example.financinhas;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TelaContasAPagar extends AppCompatActivity {

    private ArrayList<Conta> contas;
    private ContaAdapter adapter;
    int posicaoSelecionada =-1;
    private ListView lista;
    private Categoria categoria;
    Date dataVencimento;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas_a_pagar);

        Intent it = getIntent();
        categoria = (Categoria) it.getSerializableExtra("categoria_edicao");
        contas = categoria.getContas();
        lista = (ListView) findViewById(R.id.lista_contas);

        if (savedInstanceState != null) {
            contas = (ArrayList<Conta>) savedInstanceState.getSerializable("contas");
            if (contas == null){
                contas = new ArrayList<>();
            }}

        adapter = new ContaAdapter(this, contas);
        lista.setAdapter(adapter);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ((TextView) findViewById(R.id.nomeCategoria)).setText(categoria.getDescricao());

    }

    public void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putSerializable("contas",contas);
    }

    public class ContaAdapter extends ArrayAdapter<Conta> {
        public ContaAdapter(Context context, ArrayList<Conta> lista) {
            super(context, android.R.layout.simple_list_item_1, lista);
        }
        @Override
        public View getView(int posicao,  View reciclada,  ViewGroup grupo) {
            if(reciclada == null) {
                reciclada = getLayoutInflater().inflate(R.layout.item_conta, null);
            }

            if (posicao == posicaoSelecionada) {
                reciclada.setBackgroundColor(Color.WHITE);
            }
            else {
                reciclada.setBackgroundColor(Color.GRAY);
            }
            Conta conta = contas.get(posicao);

            ((TextView) reciclada.findViewById(R.id.item_conta)).setText(conta.getDescricao());
            ((TextView) reciclada.findViewById(R.id.item_valor_conta)).setText("R$ "+conta.getValor());
            ((TextView) reciclada.findViewById(R.id.item_data_despesa)).setText(simpleDateFormat.format(conta.getVencimento()));
            return reciclada;

        }
    }
    public void adicionarDespesa(View v) {
        Conta c = new Conta();
        c.setDescricao(((EditText) findViewById(R.id.ed_descricao_despesa)).getText().toString());
        c.setValor(Double.parseDouble(((EditText) findViewById(R.id.ed_valor_despesa)).getText().toString()));
        c.setVencimento(dataVencimento);
        contas.add(c);
        adapter.notifyDataSetChanged();
        ((EditText) findViewById(R.id.ed_descricao_despesa)).setText("");
        ((EditText) findViewById(R.id.ed_valor_despesa)).setText("");
        ((EditText) findViewById(R.id.ed_data_vencimento)).setText("");

    }

    public void selecionarData(View view) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            DatePickerDialog dlgDate = new DatePickerDialog(this);
            dlgDate.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.YEAR, ano);
                    cal.set(Calendar.MONTH, mes);
                    cal.set(Calendar.DAY_OF_MONTH, dia);
                    dataVencimento = cal.getTime();
                    ((EditText) findViewById(R.id.ed_data_vencimento)).setText(simpleDateFormat.format(dataVencimento));
                }
            });
            dlgDate.show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }

    public void sair(MenuItem menu) {
        Intent resp = new Intent();
        categoria.setContas(contas);
        categoria.calculaValor();
        resp.putExtra("novas_despesas", categoria);
        setResult(RESULT_OK, resp);
        finish();
    }

    public void excluir(MenuItem menu){
        int pos = lista.getCheckedItemPosition();
        if (pos >= 0) {
            Conta c = contas.get(pos);

            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Confirmação");
            alertBuilder.setMessage("Deseja remover a Conta " + c.getDescricao() + "?");
            alertBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    contas.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            });
            alertBuilder.setCancelable(false);
            alertBuilder.setNegativeButton("Não", null);
            alertBuilder.show();
        } else {
            Toast.makeText(this, "Selecione uma Conta para remover.", Toast.LENGTH_SHORT).show();
        }

    }
}
