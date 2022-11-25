
package ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import modelo.Cliente;
import remotos.ServicosCliente;

/**
 *
 * @author andre
 */

@Stateless
public class ClienteEJB implements ServicosCliente{
    
    @Inject
    CadClientes cad;

    @Override
    public void inserir(Cliente cliente) {
        cad.inserir(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        cad.remover(cliente);
    }

    @Override
    public List<Cliente> filtrar(String filtro) {
        return cad.buscarPorNome(filtro);
    }
    
    
}
