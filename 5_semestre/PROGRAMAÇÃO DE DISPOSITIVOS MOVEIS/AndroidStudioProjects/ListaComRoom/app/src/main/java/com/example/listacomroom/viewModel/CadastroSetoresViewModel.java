package com.example.listacomroom.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.listacomroom.banco.Banco;
import com.example.listacomroom.modelo.Setor;

import java.util.List;

public class CadastroSetoresViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Setor>> setores;
    private final Banco banco;

    public CadastroSetoresViewModel(Application application) {
        super(application);
        setores = new MutableLiveData<>();

        banco = Banco.getBancoInstance(getApplication().getApplicationContext());
    }

    public MutableLiveData<List<Setor>> getListaObserver() {
        return setores;
    }

    public void getAllSetor() {
        List<Setor> setorList = banco.getSetorDAO().buscarTodos();
        if (setorList.size() > 0) {
            setores.postValue(setorList);
        } else {
            setores.postValue(null);
        }
    }

    public void insertSetor(String descricao) {
        Setor setor = new Setor();
        setor.setDescricao(descricao);
        banco.getSetorDAO().inserir(setor);
        getAllSetor();
    }

    public void updateSetor(Setor setor) {
        banco.getSetorDAO().alterar(setor);
        getAllSetor();
    }

    public void deleteSetor(Setor setor) {
        banco.getSetorDAO().remover(setor);
        getAllSetor();
    }

}
