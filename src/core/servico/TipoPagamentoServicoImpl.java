package core.servico;

import api.dao.TipoPagamentoDAO;
import api.modelo.TipoPagamento;
import api.servico.TipoPagamentoServico;
import core.dao.TipoPagamentoDAOMysql;

public class TipoPagamentoServicoImpl implements TipoPagamentoServico {

    private TipoPagamentoDAO tpDAO = new TipoPagamentoDAOMysql();

    @Override
    public TipoPagamento findById(byte id) {
        return tpDAO.findById(id);
    }
}
