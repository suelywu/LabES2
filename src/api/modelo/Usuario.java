package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Usuario {
    private short id;
    private String nomeUsuario;
    private String senha;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome_usuario")
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Basic
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(nomeUsuario, usuario.nomeUsuario) &&
                Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nomeUsuario, senha);
    }
}
