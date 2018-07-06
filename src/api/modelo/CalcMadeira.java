package api.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calcs_madeira", schema = "labes_marcenaria_1", catalog = "")
public class CalcMadeira {
    private short id;
    private Short orcId;
    private Short pedId;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orc_id")
    public Short getOrcId() {
        return orcId;
    }

    public void setOrcId(Short orcId) {
        this.orcId = orcId;
    }

    @Basic
    @Column(name = "ped_id")
    public Short getPedId() {
        return pedId;
    }

    public void setPedId(Short pedId) {
        this.pedId = pedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcMadeira that = (CalcMadeira) o;
        return id == that.id &&
                Objects.equals(orcId, that.orcId) &&
                Objects.equals(pedId, that.pedId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orcId, pedId);
    }
}
