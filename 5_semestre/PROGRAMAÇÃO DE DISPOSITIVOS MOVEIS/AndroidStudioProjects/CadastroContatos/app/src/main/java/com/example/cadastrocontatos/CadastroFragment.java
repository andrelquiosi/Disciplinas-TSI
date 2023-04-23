package com.example.cadastrocontatos;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroFragment extends Fragment {

    EditText edNome, edTelefone, edEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cadastro, container, false);
        edNome = (EditText) v.findViewById(R.id.edNome);
        edTelefone = (EditText) v.findViewById(R.id.edTelefone);
        edEmail = (EditText) v.findViewById(R.id.edEmail);
        return v;
    }

    public Contato validarDados( ) {
        String nome = edNome.getText().toString().trim();
        String telefone = edTelefone.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        if (nome == null || nome.isEmpty() || telefone == null || telefone.isEmpty() || email == null || email.isEmpty()) {
            Toast.makeText(getActivity(),"Preencher todos os campos!", Toast.LENGTH_SHORT).show();
            return null;
        }
        edNome.setText("");
        edTelefone.setText("");
        edEmail.setText("");
        return new Contato(nome, telefone, email);
    }

    public void ajustarEdicao(Contato c) {
        edNome.setText( c.getNome() );
        edTelefone.setText( c.getTelefone() );
        edEmail.setText( c.getEmail() );
    }
}