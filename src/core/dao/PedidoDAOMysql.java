package core.dao;

import api.dao.PedidoDAO;
import api.modelo.ConnectionGetter;
import api.modelo.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoDAOMysql implements PedidoDAO {

    private Connection conexao;

    public PedidoDAOMysql() {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        conexao = connectionGetter.getConnection();
    }

    @Override
    public int count() {
        int count = 0;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select count(id) from pedidos;");
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from pedidos");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                pedidos.add(setNewPedido(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(pedidos);
    }

    @Override
    public List<Pedido> findByCliId(short cliId) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from pedidos where cli_id = ?");
            comandoSQL.setInt(1, cliId);
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                pedidos.add(setNewPedido(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(pedidos);
    }

    @Override
    public Pedido findById(short id) {
        Pedido pedido = new Pedido();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from pedidos where id = ?");
            comandoSQL.setInt(1, id);
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            pedido = setNewPedido(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public boolean deleteById(short id) {
        int linhasAfetadas = 0;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("delete from pedidos where id = ?");
            comandoSQL.setInt(1, id);
            linhasAfetadas = comandoSQL.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas > 0;
    }

    @Override
    public int getNextId() {
        int nextId = 0;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select auto_increment " +
                    "from TABLES where TABLE_NAME = 'pedidos'");
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            nextId = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nextId;
    }

    @Override
    public boolean insert(Pedido pedido) {
        int linhasAfetadas = 0;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("" +
                    "insert into pedidos(cli_id, form_pag, tipo_pag, qtd_parcelas, mao_de_obra, desconto) " +
                    "values(?, ?, ?, ?, ?, ?) ");
            comandoSQL.setInt(1, pedido.getCliId());
            comandoSQL.setInt(2, pedido.getFormPagId());
            comandoSQL.setInt(3, pedido.getTipoPagId());
            comandoSQL.setInt(4, pedido.getQtdParcelas());
            comandoSQL.setDouble(5, pedido.getMaoDeObra());
            comandoSQL.setDouble(6, pedido.getDesconto());
            linhasAfetadas = comandoSQL.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return linhasAfetadas > 0;
    }

    @Override
    public boolean update(Pedido pedido) {
        int linhasAfetadas = 0;
        try {
            PreparedStatement comando = conexao.prepareStatement("update pedidos " +
                    "set cli_id = ?, form_pag = ?, tipo_pag = ?," +
                    "qtd_parcelas = ?, mao_de_obra = ?, desconto = ?" +
                    "where id = ?");
            comando.setInt(1, pedido.getCliId());
            comando.setInt(2, pedido.getFormPagId());
            comando.setInt(3, pedido.getTipoPagId());
            comando.setInt(4, pedido.getQtdParcelas());
            comando.setDouble(5, pedido.getMaoDeObra());
            comando.setDouble(6, pedido.getDesconto());
            comando.setInt(7, pedido.getId());
            linhasAfetadas = comando.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas > 0;
    }

    private Pedido setNewPedido(ResultSet rs) {
        Pedido pedido = new Pedido();
        try {
            pedido.setId(rs.getShort(1));
            pedido.setCliId(rs.getShort(2));
            pedido.setData(rs.getTimestamp(3));
            pedido.setFormPagId(rs.getByte(4));
            pedido.setTipoPagId(rs.getByte(5));
            pedido.setQtdParcelas(rs.getShort(6));
            pedido.setMaoDeObra(rs.getDouble(7));
            pedido.setDesconto(rs.getDouble(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedido;
    }

}
