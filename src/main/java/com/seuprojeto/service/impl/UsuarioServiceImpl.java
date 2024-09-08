package com.seuprojeto.service.impl;

import com.seuprojeto.dao.IUsuarioDAO;
import com.seuprojeto.model.Usuario;
import com.seuprojeto.service.IUsuarioService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public boolean autenticarUsuario(String username, String password) {
        Usuario usuario = usuarioDAO.findByUsername(username);
        if (usuario != null && BCrypt.checkpw(password, usuario.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        // Criptografar a senha antes de salvar
        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
        usuarioDAO.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        // Criptografar a senha antes de atualizar
        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
        usuarioDAO.update(usuario);
    }

    @Override
    public void deleteUsuario(String username) {
        usuarioDAO.delete(username);
    }

}
