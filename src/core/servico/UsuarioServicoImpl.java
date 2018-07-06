package core.servico;

import api.dao.UsuarioDAO;
import api.modelo.Usuario;
import api.servico.UsuarioServico;
import core.dao.UsuarioDAOMysql;

public class UsuarioServicoImpl implements UsuarioServico {
    @Override
    public Usuario findByNomeUsuario(String nomeUsuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAOMysql();
        return usuarioDAO.findByNomeUsuario(nomeUsuario);
    }
}
