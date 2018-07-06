package api.dao;

import api.modelo.Pedido;

import java.util.List;

public interface PedidoDAO {

    public int count();
    public List<Pedido> findAll();
    public List<Pedido> findByCliId(short cliId);
    public Pedido findById(short id);
    public boolean deleteById(short id);
    public int getNextId();
    public boolean insert(Pedido pedido);
    public boolean update(Pedido pedido);

}
