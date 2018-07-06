package core.dao;

import api.dao.MaterialDAO;
import api.modelo.ConnectionGetter;
import api.modelo.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaterialDAOMysql implements MaterialDAO {

    private Connection conexao;

    public MaterialDAOMysql() {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        conexao = connectionGetter.getConnection();
    }

    @Override
    public List<Material> findByPedId(short pedId) {
        List<Material> materiais = new ArrayList<>();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from materiais where ped_id = ?");
            comandoSQL.setInt(1, pedId);
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                materiais.add(setNewMaterialToPedido(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(materiais);
    }

    @Override
    public boolean deleteByPedId(short pedId) {
        int linhasAfetadas = 0;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("delete from materiais where ped_id = ?");
            comandoSQL.setInt(1, pedId);
            linhasAfetadas = comandoSQL.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return linhasAfetadas > 0;
    }

    private Material setNewMaterialToPedido(ResultSet rs) {
        Material material = new Material();
        try {
            material.setId(rs.getShort(1));
            material.setDescricao(rs.getString(2));
            material.setPreco(rs.getFloat(3));
            material.setPedId(rs.getShort(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return material;
    }

    private Material setNewMaterialToOrcamento(ResultSet rs) {
        Material material = new Material();
        try {
            material.setId(rs.getShort(1));
            material.setDescricao(rs.getString(2));
            material.setPreco(rs.getFloat(3));
            material.setOrcId(rs.getShort(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return material;
    }



}
