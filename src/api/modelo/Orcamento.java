package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orcamento {
    private short id;
    private Timestamp data;
    private double maoDeObra;
    private Double desconto;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data")
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Basic
    @Column(name = "mao_de_obra")
    public double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    @Basic
    @Column(name = "desconto")
    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orcamento that = (Orcamento) o;
        return id == that.id &&
                Double.compare(that.maoDeObra, maoDeObra) == 0 &&
                Objects.equals(data, that.data) &&
                Objects.equals(desconto, that.desconto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, data, maoDeObra, desconto);
    }
}
