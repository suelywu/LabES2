package api.dao;

import api.modelo.Usuario;

public interface UsuarioDAO {
    public Usuario findByNomeUsuario(String nomeUsuario);

}
