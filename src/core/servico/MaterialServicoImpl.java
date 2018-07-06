package core.servico;

import api.dao.MaterialDAO;
import api.modelo.Material;
import api.servico.MaterialServico;
import core.dao.MaterialDAOMysql;

import java.util.List;

public class MaterialServicoImpl implements MaterialServico {

    private MaterialDAO materialDAO;

    public MaterialServicoImpl() {
        materialDAO = new MaterialDAOMysql();
    }

    @Override
    public List<Material> findByPedId(short pedId) {
        List<Material> materiais = materialDAO.findByPedId(pedId);

        return materiais;
    }
}
