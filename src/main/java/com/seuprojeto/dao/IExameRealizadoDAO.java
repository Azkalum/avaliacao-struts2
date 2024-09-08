package com.seuprojeto.dao;

import com.seuprojeto.model.ExameRealizado;

import java.util.Date;
import java.util.List;

public interface IExameRealizadoDAO {

    void save(ExameRealizado exameRealizado);
    List<ExameRealizado> findAll();
    ExameRealizado findById(int codigoFuncionario, int codigoExame);
    void update(ExameRealizado exameRealizado);
    void delete(int codigoFuncionario, int codigoExame);
    List<ExameRealizado> findByPeriodo(Date dataInicio, Date dataFim);

}
