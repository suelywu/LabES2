package api.servico;

import api.modelo.FormaPagamento;

public interface FormaPagamentoServico {
    public FormaPagamento findById(byte id);
}
