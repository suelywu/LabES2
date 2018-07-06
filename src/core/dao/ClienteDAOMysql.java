package core.dao;

import api.dao.ClienteDAO;
import api.modelo.Cliente;
import api.modelo.ConnectionGetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteDAOMysql implements ClienteDAO {

    private Connection conexao;

    public ClienteDAOMysql() {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        conexao = connectionGetter.getConnection();
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from clientes;");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()){
                clientes.add(setNewCliente(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(clientes);
    }

    @Override
    public Cliente findById(short id) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from clientes where id = ?");
            comandoSQL.setInt(1, id);
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            cliente = setNewCliente(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from clientes where nome like ?");
            comandoSQL.setString(1, "%" + nome + "%");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()){
                clientes.add(setNewCliente(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(clientes);
    }

    private Cliente setNewCliente(ResultSet rs) {
        Cliente cliente = new Cliente();
        try {
            cliente.setId(rs.getShort(1));
            cliente.setNome(rs.getString(2));
            cliente.setEndereco(rs.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
