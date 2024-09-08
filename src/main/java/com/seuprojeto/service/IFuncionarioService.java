package com.seuprojeto.service;

import com.seuprojeto.model.Funcionario;

import java.util.List;

public interface IFuncionarioService {

    void addFuncionario(Funcionario funcionario);
    List<Funcionario> getAllFuncionarios();
    Funcionario getFuncionarioByCodigo(int codigo);
    void updateFuncionario(Funcionario funcionario);
    void deleteFuncionario(int codigo);

}
