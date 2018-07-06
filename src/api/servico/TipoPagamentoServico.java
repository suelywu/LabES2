package api.servico;

import api.modelo.TipoPagamento;

public interface TipoPagamentoServico {
    public TipoPagamento findById(byte id);
}
