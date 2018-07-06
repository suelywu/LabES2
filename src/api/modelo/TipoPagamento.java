package api.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipos_pagamento", schema = "labes_marcenaria_1", catalog = "")
public class TipoPagamento {
    private byte id;
    private String tipo;

    @Id
    @Column(name = "id")
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPagamento that = (TipoPagamento) o;
        return id == that.id &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tipo);
    }
}
