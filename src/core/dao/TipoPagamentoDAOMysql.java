package core.dao;

import api.dao.TipoPagamentoDAO;
import api.modelo.ConnectionGetter;
import api.modelo.TipoPagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TipoPagamentoDAOMysql implements TipoPagamentoDAO {

    private Connection conexao;

    public TipoPagamentoDAOMysql() {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        conexao = connectionGetter.getConnection();
    }

    @Override
    public TipoPagamento findById(byte id) {
        TipoPagamento tipoPagamento = new TipoPagamento();
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select * from tipos_pagamento where id = ?");
            comandoSQL.setInt(1, id);
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            tipoPagamento = setnewTipoPag(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoPagamento;
    }

    private TipoPagamento setnewTipoPag(ResultSet rs) {
        TipoPagamento tipoPagamento = new TipoPagamento();
        try {
            tipoPagamento.setId(rs.getByte(1));
            tipoPagamento.setTipo(rs.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoPagamento;
    }
}
