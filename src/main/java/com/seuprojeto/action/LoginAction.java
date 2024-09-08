package com.seuprojeto.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.seuprojeto.dao.impl.UsuarioDAOImpl;
import com.seuprojeto.model.Usuario;
import com.seuprojeto.service.IUsuarioService;
import com.seuprojeto.service.impl.UsuarioServiceImpl;

import java.util.Map;

public class LoginAction extends ActionSupport {

    private String username;
    private String password;
    private IUsuarioService usuarioService;

    public LoginAction() {
        this.usuarioService = new UsuarioServiceImpl(new UsuarioDAOImpl());
    }

    public String execute() {
        if (usuarioService.autenticarUsuario(username, password)) {

            Usuario usuario = usuarioService.getAllUsuarios().stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);

            if (usuario != null) {
                Map<String, Object> session = ActionContext.getContext().getSession();
                session.put("username", username);
                session.put("tempoInatividade", usuario.getTempoInatividade());
                return SUCCESS;
            }
        } else {
            addActionError("Usuário ou senha inválidos");
        }
        return LOGIN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
