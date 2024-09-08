package com.seuprojeto.action;

import com.opensymphony.xwork2.ActionSupport;
import com.seuprojeto.dao.impl.FuncionarioDAOImpl;
import com.seuprojeto.model.Funcionario;
import com.seuprojeto.service.IFuncionarioService;
import com.seuprojeto.service.impl.FuncionarioServiceImpl;

import java.util.List;

public class FuncionarioAction extends ActionSupport {

    private IFuncionarioService funcionarioService;
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private int codigo;

    public FuncionarioAction() {
        this.funcionarioService = new FuncionarioServiceImpl(new FuncionarioDAOImpl());
    }

    public String create() {
        funcionarioService.addFuncionario(funcionario);
        return SUCCESS;
    }

    public String list() {
        funcionarios = funcionarioService.getAllFuncionarios();
        return SUCCESS;
    }

    public String edit() {
        funcionario = funcionarioService.getFuncionarioByCodigo(codigo);
        return SUCCESS;
    }

    public String update() {
        funcionarioService.updateFuncionario(funcionario);
        return SUCCESS;
    }

    public String delete() {
        funcionarioService.deleteFuncionario(codigo);
        return SUCCESS;
    }

    public IFuncionarioService getFuncionarioService() {
        return funcionarioService;
    }

    public void setFuncionarioService(IFuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
