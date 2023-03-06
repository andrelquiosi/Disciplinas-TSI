package ejbs;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import modelo.Cliente;

/**
 *
 * @author andre
 */
@Singleton
public class CadClientes {

    private final List<Cliente> clientes = new LinkedList<Cliente>();

    public void inserir(Cliente c) {
        if (!clientes.contains(c)) {
            clientes.add(c);
        }
    }

    public void remover(Cliente c) {
        clientes.remove(c);
    }

    @Lock(LockType.READ)
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> resp = new LinkedList<>();
        if (nome == null || nome.trim().isEmpty()) {
            resp.addAll(clientes);
        } else {
            for (Cliente cliente : clientes) {
                if (cliente.getNome().contains(nome)) {
                    resp.add(cliente);
                }

            }

        }
        return resp;
    }

    Cliente buscar(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }

        }
        return null;
    }

    void alterar(Cliente cliente) {
        int pos = clientes.indexOf(cliente);
        if (pos >= 0) {
            clientes.set(pos, cliente);
        }
    }

}
