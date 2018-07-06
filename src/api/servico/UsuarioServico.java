package api.servico;

import api.modelo.Usuario;

public interface UsuarioServico {
    public Usuario findByNomeUsuario(String nomeUsuario);
}
