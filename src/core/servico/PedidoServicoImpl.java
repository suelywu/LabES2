package core.servico;

import api.dao.*;
import api.modelo.Cliente;
import api.modelo.Pedido;
import api.servico.PedidoServico;
import core.dao.*;

import java.util.List;

public class PedidoServicoImpl implements PedidoServico {

    private ClienteDAO clienteDAO;
    private PedidoDAO pedidoDAO;
    private MaterialDAO materialDAO;
    private FormaPagamentoDAO fpDAO;
    private TipoPagamentoDAO tpDAO;

    public PedidoServicoImpl() {
        clienteDAO = new ClienteDAOMysql();
        pedidoDAO = new PedidoDAOMysql();
        materialDAO = new MaterialDAOMysql();
        fpDAO = new FormaPagamentoDAOMysql();
        tpDAO = new TipoPagamentoDAOMysql();
    }

    @Override
    public int count() {
        int count =pedidoDAO.count();
        System.out.println("Qtd pedidos: " + count);
        return count;
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = pedidoDAO.findAll();
        for (Pedido p : pedidos) {
            short id = p.getId();
            p.setCliente(clienteDAO.findById(p.getCliId()));
            p.setMateriais(materialDAO.findByPedId(id));
            p.setFormPag(fpDAO.findById(p.getFormPagId()));
            p.setTipoPag(tpDAO.findById(p.getTipoPagId()));
        }
        return pedidos;
    }

    @Override
    public List<Pedido> findByCliId(short cliId) {
        List<Pedido> pedidos = pedidoDAO.findByCliId(cliId);
        Cliente cliente = clienteDAO.findById(cliId);
        for (Pedido p : pedidos) {
            short id = p.getId();
            p.setCliente(cliente);
            p.setMateriais(materialDAO.findByPedId(id));
        }
        return pedidos;
    }

    @Override
    public Pedido findById(short id) {
        Pedido p = pedidoDAO.findById(id);
        short cliId = p.getCliId();
        Cliente c = clienteDAO.findById(cliId);
        p.setCliente(c);
        p.setMateriais(materialDAO.findByPedId(id));
        p.setFormPag(fpDAO.findById(p.getFormPagId()));
        p.setTipoPag(tpDAO.findById(p.getTipoPagId()));
        return p;
    }

    @Override
    public boolean deleteById(short id) {
        if (materialDAO.deleteByPedId(id)) {
            return pedidoDAO.deleteById(id);
        }
        return pedidoDAO.deleteById(id);
    }

    @Override
    public int getNextId() {
        return pedidoDAO.getNextId();
    }

    @Override
    public boolean insert(Pedido pedido) {
        return pedidoDAO.insert(pedido);
    }

    @Override
    public boolean update(Pedido pedido) {
        return pedidoDAO.update(pedido);
    }
}
