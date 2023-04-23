package com.example.contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TelaContato extends AppCompatActivity {

    Date dataNascimento;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_contato);
        Intent it = getIntent();

        if (it != null) {

            Contato ed = (Contato) it.getSerializableExtra("contato_edicao");

            if (ed != null) {

                ((EditText) findViewById(R.id.ed_nome)).setText(ed.getNome());
                ((EditText) findViewById(R.id.ed_email)).setText(ed.getEmail());
                ((EditText) findViewById(R.id.ed_telefone)).setText(ed.getTelefone());
                ((EditText) findViewById(R.id.ed_endereco)).setText(ed.getEndereco());
                dataNascimento = ed.getDataNascimento();
                if (dataNascimento != null)
                    ((EditText) findViewById(R.id.ed_data_nasc)).setText(sdf.format(dataNascimento));

            }
        }
    }

    public void cancelar(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void confirmar(View v) {
        Contato c = new Contato();
        c.setNome(((EditText) findViewById(R.id.ed_nome)).getText().toString());
        c.setEndereco(((EditText) findViewById(R.id.ed_endereco)).getText().toString());
        c.setTelefone(((EditText) findViewById(R.id.ed_telefone)).getText().toString());
        c.setEmail(((EditText) findViewById(R.id.ed_email)).getText().toString());
        c.setDataNascimento(dataNascimento);
        Intent resp = new Intent();
        resp.putExtra("novo_contato", c);
        setResult(RESULT_OK, resp);
        finish();
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
                    dataNascimento = cal.getTime();
                    ((EditText) findViewById(R.id.ed_data_nasc)).setText(sdf.format(dataNascimento));
                }
            });
            dlgDate.show();
        }

    }
}