package api.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido {
    private short id;
    private short cliId;
    private Timestamp data;
    private byte formPagId;
    private byte tipoPagId;
    private int qtdParcelas;
    private double maoDeObra;
    private double desconto;
    private Cliente cliente;
    private List<Material> materiais;
    private FormaPagamento formPag;
    private TipoPagamento tipoPag;

    public FormaPagamento getFormPag() {
        return formPag;
    }

    public void setFormPag(FormaPagamento formPag) {
        this.formPag = formPag;
    }

    public TipoPagamento getTipoPag() {
        return tipoPag;
    }

    public void setTipoPag(TipoPagamento tipoPag) {
        this.tipoPag = tipoPag;
    }

    public List<Material> getMateriais() {
        return Collections.unmodifiableList(materiais);
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
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
    @Column(name = "data")
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
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
    @Column(name = "form_pag")
    public byte getFormPagId() {
        return formPagId;
    }

    public void setFormPagId(byte formPag) {
        this.formPagId = formPag;
    }

    @Basic
    @Column(name = "tipo_pag")
    public byte getTipoPagId() {
        return tipoPagId;
    }

    public void setTipoPagId(byte tipoPag) {
        this.tipoPagId = tipoPag;
    }

    @Basic
    @Column(name = "qtd_parcelas")
    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
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
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id &&
                formPagId == pedido.formPagId &&
                tipoPagId == pedido.tipoPagId &&
                qtdParcelas == pedido.qtdParcelas &&
                Double.compare(pedido.maoDeObra, maoDeObra) == 0 &&
                Double.compare(pedido.desconto, desconto) == 0 &&
                Objects.equals(data, pedido.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, data, formPagId, tipoPagId, qtdParcelas, maoDeObra, desconto);
    }


    @Override
    public String toString() {
        String str = "" +
                "id = " + id + "\n" +
                "cliId = " + cliId + "\n" +
                "form pag id = " + formPagId + "\n" +
                "tipo pag id = " + tipoPagId + "\n" +
                "mao de obra = " + maoDeObra + "\n" +
                "desconto = " + desconto + "\n" +
                "qtd parcelas = " + qtdParcelas;
        return str;
    }

}
