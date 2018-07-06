package api.dao;

import api.modelo.Material;

import java.util.List;

public interface MaterialDAO {
    public List<Material> findByPedId(short pedId);
    public boolean deleteByPedId(short pedId);
}
