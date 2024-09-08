package com.seuprojeto.dao.impl;

import com.seuprojeto.dao.IFuncionarioDAO;
import com.seuprojeto.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOImpl implements IFuncionarioDAO {

    private Connection connection;

    public FuncionarioDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avaliacao", "root", "RenanAlmeida24#");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Funcionario funcionario) {
        try {
            String query = "INSERT INTO funcionario (codigo, nome) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, funcionario.getCodigo());
            ps.setString(2, funcionario.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM funcionario";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("codigo"));
                funcionario.setNome(rs.getString("nome"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    @Override
    public Funcionario findByCodigo(int codigo) {
        Funcionario funcionario = null;
        try {
            String query = "SELECT * FROM funcionario WHERE codigo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("codigo"));
                funcionario.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    @Override
    public void update(Funcionario funcionario) {
        try {
            String query = "UPDATE funcionario SET nome = ? WHERE codigo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            String deleteExamesRealizados = "DELETE FROM exame_realizado WHERE codigo_funcionario = ?";
            PreparedStatement psExames = connection.prepareStatement(deleteExamesRealizados);
            psExames.setInt(1, codigo);
            psExames.executeUpdate();

            String deleteFuncionario = "DELETE FROM funcionario WHERE codigo = ?";
            PreparedStatement psFuncionario = connection.prepareStatement(deleteFuncionario);
            psFuncionario.setInt(1, codigo);
            psFuncionario.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

