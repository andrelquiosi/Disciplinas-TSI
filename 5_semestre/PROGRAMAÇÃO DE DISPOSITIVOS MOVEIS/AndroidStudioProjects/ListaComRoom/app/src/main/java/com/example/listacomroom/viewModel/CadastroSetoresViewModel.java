package com.example.listacomroom.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.listacomroom.banco.Banco;
import com.example.listacomroom.modelo.ListaDeCompras;

import java.util.List;

public class CadastroSetoresViewModel extends AndroidViewModel {

    private MutableLiveData<List<ListaDeCompras>> listaDeCompras;
    private Banco banco;

    public CadastroSetoresViewModel(Application application) {
        super(application);
        listaDeCompras = new MutableLiveData<>();

        banco = Banco.getBancoInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<ListaDeCompras>> getListaObserver() {
        return listaDeCompras;
    }

    public void getAllListaDeCompras() {
        List<ListaDeCompras> lista = banco.getListaDeComprasDAO().buscarTodos();
        if (lista.size() > 0) {
            listaDeCompras.postValue(lista);
        } else {
            listaDeCompras.postValue(null);
        }
    }

    public void insertListaDeCompras(String descricao) {
        ListaDeCompras lista = new ListaDeCompras();
        lista.setDescricao(descricao);
        banco.getListaDeComprasDAO().inserir(lista);
        getAllListaDeCompras();
    }

    public void updateListaDeCompras(ListaDeCompras lista) {
        banco.getListaDeComprasDAO().atualizar(lista);
        getAllListaDeCompras();
    }

    public void deleteListaDeCompras(ListaDeCompras lista) {
        banco.getListaDeComprasDAO().remover(lista);
        getAllListaDeCompras();
    }

}
