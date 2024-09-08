package com.seuprojeto.dao;

import com.seuprojeto.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {

    void save(Usuario usuario);
    List<Usuario> findAll();
    Usuario findByUsername(String username);
    void update(Usuario usuario);
    void delete(String username);

}
