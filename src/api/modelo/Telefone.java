package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Telefone {
    private short id;
    private short cliId;
    private byte ddd;
    private int telefone;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cli_id")
    public short getCliId() {
        return cliId;
    }

    public void setCliId(short cliId) {
        this.cliId = cliId;
    }

    @Basic
    @Column(name = "ddd")
    public byte getDdd() {
        return ddd;
    }

    public void setDdd(byte ddd) {
        this.ddd = ddd;
    }

    @Basic
    @Column(name = "telefone")
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return id == telefone.id &&
                cliId == telefone.cliId &&
                ddd == telefone.ddd &&
                this.telefone == telefone.telefone;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cliId, ddd, telefone);
    }
}
