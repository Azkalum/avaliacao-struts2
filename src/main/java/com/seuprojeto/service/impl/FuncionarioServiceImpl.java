package com.seuprojeto.service.impl;

import com.seuprojeto.dao.IFuncionarioDAO;
import com.seuprojeto.model.Funcionario;
import com.seuprojeto.service.IFuncionarioService;

import java.util.List;

public class FuncionarioServiceImpl implements IFuncionarioService {

    private IFuncionarioDAO funcionarioDAO;

    public FuncionarioServiceImpl(IFuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    @Override
    public void addFuncionario(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    @Override
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioDAO.findAll();
    }

    @Override
    public Funcionario getFuncionarioByCodigo(int codigo) {
        return funcionarioDAO.findByCodigo(codigo);
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
    }

    @Override
    public void deleteFuncionario(int codigo) {
        funcionarioDAO.delete(codigo);
    }
}
