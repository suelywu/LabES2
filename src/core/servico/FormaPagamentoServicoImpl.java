package core.servico;

import api.dao.FormaPagamentoDAO;
import api.modelo.FormaPagamento;
import api.servico.FormaPagamentoServico;
import core.dao.FormaPagamentoDAOMysql;

public class FormaPagamentoServicoImpl implements FormaPagamentoServico {

    private FormaPagamentoDAO fpDAO = new FormaPagamentoDAOMysql();

    @Override
    public FormaPagamento findById(byte id) {
        return fpDAO.findById(id);
    }
}
