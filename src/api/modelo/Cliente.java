package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    private short id;
    private String nome;
    private String endereco;
    private List<Pedido> pedidos;

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "endereco")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, endereco);
    }
}
