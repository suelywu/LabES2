package api.servico;

import api.modelo.Cliente;

import java.util.List;

public interface ClienteServico {

    public List<Cliente> findAll();
    public List<Cliente> findByCliNome(String cliNome);
    public Cliente findById(short id);

}
