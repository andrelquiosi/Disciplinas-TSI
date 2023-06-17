package com.example.listacomroom.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.listacomroom.banco.Banco;
import com.example.listacomroom.modelo.Produto;

import java.util.List;

public class ShowItemListActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Produto>> listOfProduto;
    private Banco appDatabase;

    public ShowItemListActivityViewModel(Application application) {
        super(application);
        listOfProduto = new MutableLiveData<>();

        appDatabase = Banco.getBancoInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Produto>>  getProdutoListObserver() {
        return listOfProduto;
    }

    public void getAllProdutoList(long id) {
        List<Produto> itemsList= (List<Produto>) appDatabase.getProdutoDAO().buscarPorDepartamento(id);
        if(itemsList.size() > 0)
        {
            listOfProduto.postValue(itemsList);
        }else {
            listOfProduto.postValue(null);
        }
    }

    public void inserirProdutos(Produto produto) {

        appDatabase.getProdutoDAO().inserir(produto);
        getAllProdutoList(produto.getIdLista());
    }

    public void atualizarProdutos(Produto produto) {
        appDatabase.getProdutoDAO().atualizar(produto);
        getAllProdutoList(produto.getIdLista());
    }

    public void deleteProduto(Produto produto) {
        appDatabase.getProdutoDAO().remover(produto);
        getAllProdutoList(produto.getIdLista());
    }

}
