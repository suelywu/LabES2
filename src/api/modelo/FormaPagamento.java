package api.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "formas_pagamento", schema = "labes_marcenaria_1", catalog = "")
public class FormaPagamento {
    private byte id;
    private String forma;

    @Id
    @Column(name = "id")
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    @Basic
    @Column(name = "forma")
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPagamento that = (FormaPagamento) o;
        return id == that.id &&
                Objects.equals(forma, that.forma);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, forma);
    }
}
