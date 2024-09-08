package com.seuprojeto.dao.impl;

import com.seuprojeto.dao.IExameDAO;
import com.seuprojeto.model.Exame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExameDAOImpl implements IExameDAO {

    private Connection connection;

    public ExameDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avaliacao", "root", "RenanAlmeida24#");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Exame exame) {
        try {
            String query = "INSERT INTO exame (nome, descricao, ativo) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, exame.getNome());
            ps.setString(2, exame.getDescricao());
            ps.setBoolean(3, exame.isAtivo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Exame> findAll() {
        List<Exame> exames = new ArrayList<>();
        try {
            String query = "SELECT * FROM exame";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Exame exame = new Exame();
                exame.setId(rs.getInt("id"));
                exame.setNome(rs.getString("nome"));
                exame.setDescricao(rs.getString("descricao"));
                exame.setAtivo(rs.getBoolean("ativo"));
                exames.add(exame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exames;
    }

    @Override
    public Exame findById(int id) {
        Exame exame = null;
        try {
            String query = "SELECT * FROM exame WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exame = new Exame();
                exame.setId(rs.getInt("id"));
                exame.setNome(rs.getString("nome"));
                exame.setDescricao(rs.getString("descricao"));
                exame.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exame;
    }

    @Override
    public void update(Exame exame) {
        try {
            String query = "UPDATE exame SET nome = ?, descricao = ?, ativo = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, exame.getNome());
            ps.setString(2, exame.getDescricao());
            ps.setBoolean(3, exame.isAtivo());
            ps.setInt(4, exame.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String checkExameRealizado = "SELECT COUNT(*) FROM exame_realizado WHERE codigo_exame = ?";
            PreparedStatement psCheck = connection.prepareStatement(checkExameRealizado);
            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Se o exame foi realizado, não permitir a exclusão
                System.out.println("Exame não pode ser deletado, pois já foi realizado por um ou mais funcionários.");
                return;
            }

            String deleteExame = "DELETE FROM exame WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteExame);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Exame> findByStatus(Boolean ativo) {
        List<Exame> exames = new ArrayList<>();
        try {
            String query = "SELECT * FROM exame WHERE ativo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1, ativo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exame exame = new Exame();
                exame.setId(rs.getInt("id"));
                exame.setNome(rs.getString("nome"));
                exame.setDescricao(rs.getString("descricao"));
                exame.setAtivo(rs.getBoolean("ativo"));
                exames.add(exame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exames;
    }

    @Override
    public List<Exame> findByNome(String nome) {
        List<Exame> exames = new ArrayList<>();
        try {
            String query = "SELECT * FROM exame WHERE nome LIKE ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exame exame = new Exame();
                exame.setId(rs.getInt("id"));
                exame.setNome(rs.getString("nome"));
                exame.setDescricao(rs.getString("descricao"));
                exame.setAtivo(rs.getBoolean("ativo"));
                exames.add(exame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exames;
    }

    @Override
    public Exame findByCodigo(int id) {
        return findById(id);
    }
}
