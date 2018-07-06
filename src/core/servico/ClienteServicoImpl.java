package core.servico;

import api.dao.ClienteDAO;
import api.dao.PedidoDAO;
import api.modelo.Cliente;
import api.modelo.Pedido;
import api.servico.ClienteServico;
import core.dao.ClienteDAOMysql;
import core.dao.PedidoDAOMysql;

import java.util.List;

public class ClienteServicoImpl implements ClienteServico {

    private ClienteDAO clienteDAO;
    private PedidoDAO pedidoDAO;

    public ClienteServicoImpl() {
        clienteDAO = new ClienteDAOMysql();
        pedidoDAO = new PedidoDAOMysql();
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteDAO.findAll();
        for (Cliente c : clientes) {
            short id = c.getId();
            List<Pedido> pedidos = pedidoDAO.findByCliId(id);
            c.setPedidos(pedidos);
        }
        return clientes;
    }

    @Override
    public List<Cliente> findByCliNome(String cliNome) {
        List<Cliente> clientes = clienteDAO.findByNome(cliNome);
        for (Cliente c : clientes) {
            short id = c.getId();
            List<Pedido> pedidos = pedidoDAO.findByCliId(id);
            c.setPedidos(pedidos);
        }
        return clientes;
    }

    @Override
    public Cliente findById(short id) {
        Cliente cliente = clienteDAO.findById(id);
        cliente.setPedidos(pedidoDAO.findByCliId(id));
        return cliente;
    }
}
