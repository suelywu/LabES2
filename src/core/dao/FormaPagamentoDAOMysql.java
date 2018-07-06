package core.dao;

import api.dao.FormaPagamentoDAO;
import api.modelo.ConnectionGetter;
import api.modelo.FormaPagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FormaPagamentoDAOMysql implements FormaPagamentoDAO {

    private Connection conexao;

    public FormaPagamentoDAOMysql() {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        conexao = connectionGetter.getConnection();
    }

    @Override
    public FormaPagamento findById(byte id) {
        FormaPagamento formaPagamento = new FormaPagamento();
        try {
            PreparedStatement comandoSQl = conexao.prepareStatement("select * from formas_pagamento where id = ?");
            comandoSQl.setInt(1, id);
            ResultSet rs = comandoSQl.executeQuery();
            rs.next();
            formaPagamento = setNewFormaPagamento(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formaPagamento;
    }

    private FormaPagamento setNewFormaPagamento(ResultSet rs) {
        FormaPagamento formaPagamento = new FormaPagamento();
        try {
            formaPagamento.setId(rs.getByte(1));
            formaPagamento.setForma(rs.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formaPagamento;
    }
}
