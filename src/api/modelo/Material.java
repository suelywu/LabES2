package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Material {
    private short id;
    private String descricao;
    private double preco;
    private Short pedId;
    private Short orcId;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "preco")
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Basic
    @Column(name = "ped_id")
    public Short getPedId() {
        return pedId;
    }

    public void setPedId(Short pedId) {
        this.pedId = pedId;
    }

    @Basic
    @Column(name = "orc_id")
    public Short getOrcId() {
        return orcId;
    }

    public void setOrcId(Short orcId) {
        this.orcId = orcId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return id == material.id &&
                Double.compare(material.preco, preco) == 0 &&
                Objects.equals(descricao, material.descricao) &&
                Objects.equals(pedId, material.pedId) &&
                Objects.equals(orcId, material.orcId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, descricao, preco, pedId, orcId);
    }
}
