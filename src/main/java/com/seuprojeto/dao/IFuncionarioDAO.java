package com.seuprojeto.dao;

import com.seuprojeto.model.Funcionario;

import java.util.List;

public interface IFuncionarioDAO {

    void save(Funcionario funcionario);
    List<Funcionario> findAll();
    Funcionario findByCodigo(int codigo);
    void update(Funcionario funcionario);
    void delete(int codigo);

}
