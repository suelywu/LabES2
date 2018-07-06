package core.dao;

import api.dao.UsuarioDAO;
import api.modelo.ConnectionGetter;
import api.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOMysql implements UsuarioDAO {

    private Connection conexao;

    public UsuarioDAOMysql() {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        conexao = connectionGetter.getConnection();
    }

    @Override
    public Usuario findByNomeUsuario(String nomeUsuario) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from usuarios where nome_usuario = ?");
            comandoSQL.setString(1, nomeUsuario);
            //PreparedStatement comandoSQL = conexao.prepareStatement("select * from usuarios");
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            usuario = setNewUsuario(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    private Usuario setNewUsuario(ResultSet rs) {
        Usuario usuario = new Usuario();
        try {
            usuario.setId(rs.getShort(1));
            usuario.setNomeUsuario(rs.getString(2));
            usuario.setSenha(rs.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
