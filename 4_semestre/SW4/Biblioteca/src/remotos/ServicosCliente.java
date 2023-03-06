package remotos;

import java.util.List;
import javax.ejb.Remote;
import modelo.Cliente;

/**
 *
 * @author andre
 */

@Remote
public interface ServicosCliente {
    public void inserir(Cliente cliente);
    public void remover(Cliente cliente);
    public List<Cliente> filtrar(String filtro);
    public Cliente buscar(String cpf);
    public void alterar(Cliente cliente);
}
