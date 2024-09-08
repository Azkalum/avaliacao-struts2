package com.seuprojeto.dao.impl;

import com.seuprojeto.dao.IUsuarioDAO;
import com.seuprojeto.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements IUsuarioDAO {
    private Connection connection;

    public UsuarioDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avaliacao", "root", "#");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Usuario usuario) {
        try {
            String query = "INSERT INTO usuario (username, password, tempo_inatividade) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword()); // A senha deve ser criptografada antes
            ps.setInt(3, usuario.getTempoInatividade());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM usuario";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTempoInatividade(rs.getInt("tempo_inatividade"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario findByUsername(String username) {
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM usuario WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTempoInatividade(rs.getInt("tempo_inatividade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        try {
            String query = "UPDATE usuario SET password = ?, tempo_inatividade = ? WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getPassword()); // A senha deve ser criptografada antes
            ps.setInt(2, usuario.getTempoInatividade());
            ps.setString(3, usuario.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {
        try {
            String query = "DELETE FROM usuario WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}