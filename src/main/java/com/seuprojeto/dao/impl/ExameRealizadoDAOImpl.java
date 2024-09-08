package com.seuprojeto.dao.impl;

import com.seuprojeto.dao.IExameRealizadoDAO;
import com.seuprojeto.model.ExameRealizado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExameRealizadoDAOImpl implements IExameRealizadoDAO {

    private Connection connection;

    public ExameRealizadoDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avaliacao", "root", "RenanAlmeida24#");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(ExameRealizado exameRealizado) {
        try {
            String checkDuplicado = "SELECT COUNT(*) FROM exame_realizado WHERE codigo_funcionario = ? AND codigo_exame = ? AND data_realizacao = ?";
            PreparedStatement psCheck = connection.prepareStatement(checkDuplicado);
            psCheck.setInt(1, exameRealizado.getCodigoFuncionario());
            psCheck.setInt(2, exameRealizado.getCodigoExame());
            psCheck.setDate(3, new java.sql.Date(exameRealizado.getDataRealizacao().getTime()));
            ResultSet rs = psCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Exame já realizado por este funcionário na mesma data.");
                return;
            }

            String query = "INSERT INTO exame_realizado (codigo_funcionario, codigo_exame, data_realizacao) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, exameRealizado.getCodigoFuncionario());
            ps.setInt(2, exameRealizado.getCodigoExame());
            ps.setDate(3, new java.sql.Date(exameRealizado.getDataRealizacao().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExameRealizado> findAll() {
        List<ExameRealizado> examesRealizados = new ArrayList<>();
        try {
            String query = "SELECT * FROM exame_realizado";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ExameRealizado exameRealizado = new ExameRealizado();
                exameRealizado.setCodigoFuncionario(rs.getInt("codigo_funcionario"));
                exameRealizado.setCodigoExame(rs.getInt("codigo_exame"));
                exameRealizado.setDataRealizacao(rs.getDate("data_realizacao"));
                examesRealizados.add(exameRealizado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examesRealizados;
    }

    @Override
    public ExameRealizado findById(int codigoFuncionario, int codigoExame) {
        ExameRealizado exameRealizado = null;
        try {
            String query = "SELECT * FROM exame_realizado WHERE codigo_funcionario = ? AND codigo_exame = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, codigoFuncionario);
            ps.setInt(2, codigoExame);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exameRealizado = new ExameRealizado();
                exameRealizado.setCodigoFuncionario(rs.getInt("codigo_funcionario"));
                exameRealizado.setCodigoExame(rs.getInt("codigo_exame"));
                exameRealizado.setDataRealizacao(rs.getDate("data_realizacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exameRealizado;
    }

    @Override
    public void update(ExameRealizado exameRealizado) {
        try {
            String query = "UPDATE exame_realizado SET data_realizacao = ? WHERE codigo_funcionario = ? AND codigo_exame = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(exameRealizado.getDataRealizacao().getTime()));
            ps.setInt(2, exameRealizado.getCodigoFuncionario());
            ps.setInt(3, exameRealizado.getCodigoExame());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigoFuncionario, int codigoExame) {
        try {
            String query = "DELETE FROM exame_realizado WHERE codigo_funcionario = ? AND codigo_exame = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, codigoFuncionario);
            ps.setInt(2, codigoExame);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExameRealizado> findByPeriodo(java.util.Date dataInicio, java.util.Date dataFim) {
        List<ExameRealizado> examesRealizados = new ArrayList<>();
        try {
            String query = "SELECT * FROM exame_realizado WHERE data_realizacao BETWEEN ? AND ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(dataInicio.getTime()));
            ps.setDate(2, new java.sql.Date(dataFim.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ExameRealizado exameRealizado = new ExameRealizado();
                exameRealizado.setCodigoFuncionario(rs.getInt("codigo_funcionario"));
                exameRealizado.setCodigoExame(rs.getInt("codigo_exame"));
                exameRealizado.setDataRealizacao(rs.getDate("data_realizacao"));
                examesRealizados.add(exameRealizado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examesRealizados;
    }

}
