package api.dao;

import api.modelo.Cliente;

import java.util.List;

public interface ClienteDAO {
    public List<Cliente> findAll();
    public Cliente findById(short id);
    public List<Cliente> findByNome(String nome);
}
