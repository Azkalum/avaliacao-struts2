package com.seuprojeto.service;

import com.seuprojeto.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    boolean autenticarUsuario(String username, String password);
    void saveUsuario(Usuario usuario);
    List<Usuario> getAllUsuarios();
    void updateUsuario(Usuario usuario);
    void deleteUsuario(String username);

}
