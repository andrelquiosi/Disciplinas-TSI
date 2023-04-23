package com.example.cadastrocontatos;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Contato> contatos;
    ListView lista;
    ContatoAdapter adapter;
    int selectedPosition = -1;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        if (pos == selectedPosition) {
            selectedPosition = -1;
        } else {
            selectedPosition = pos;
        }
        adapter.notifyDataSetChanged();
    }

    class ContatoAdapter extends ArrayAdapter<Contato> {
        public ContatoAdapter(Context ctx) {
            super(getActivity(), 0, contatos);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public View getView(int pos, View recycled, ViewGroup grupo) {
            View v = recycled;
            if (v == null) {
                v = getLayoutInflater().inflate(R.layout.item_contato, null);
            }
            Contato c = contatos.get(pos);
            ((TextView) v.findViewById(R.id.item_nome)).setText(c.getNome());
            ((TextView) v.findViewById(R.id.item_email)).setText(c.getEmail());
            ((TextView) v.findViewById(R.id.item_telefone)).setText(c.getTelefone());
            if (pos == selectedPosition) {
                v.setBackgroundColor( Color.LTGRAY);
            } else {
                v.setBackgroundColor( Color.WHITE);
            }
            return v;
        }
     }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        lista = (ListView) v.findViewById(R.id.listaContatos);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setOnItemClickListener(this);
        return v;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
        adapter = new ContatoAdapter( getActivity() );
        lista.setAdapter( adapter );
    }

    public Contato getContatoSelecionado() {
        if (selectedPosition < 0) {
            return null;
        }
        return contatos.get( selectedPosition );
    }

    public void adicionar(Contato c) {
        contatos.add( c );
        adapter.notifyDataSetChanged();
    }

    public void substituir( Contato old, Contato novo) {
        int pos = contatos.indexOf( old );
        if (pos >= 0) {
            contatos.set( pos, novo);
            adapter.notifyDataSetChanged();
        }
    }

    public boolean remover() {
        if (selectedPosition >= 0) {
            contatos.remove(selectedPosition);
            selectedPosition = -1;
            adapter.notifyDataSetChanged();
            return true;
        }
        return false;
    }
}