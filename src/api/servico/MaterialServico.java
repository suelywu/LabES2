package api.servico;

import api.modelo.Material;

import java.util.List;

public interface MaterialServico {
    public List<Material> findByPedId(short pedId);
}
