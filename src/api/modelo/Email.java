package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Email {
    private short id;
    private short cliId;
    private String endereco;

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
        Email email = (Email) o;
        return id == email.id &&
                cliId == email.cliId &&
                Objects.equals(endereco, email.endereco);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cliId, endereco);
    }
}
