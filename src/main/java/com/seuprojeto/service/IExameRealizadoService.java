package com.seuprojeto.service;

import com.seuprojeto.model.ExameRealizado;

import java.util.Date;
import java.util.List;

public interface IExameRealizadoService {

    void addExameRealizado(ExameRealizado exameRealizado);
    List<ExameRealizado> getAllExamesRealizados();
    ExameRealizado getExameRealizadoById(int codigoFuncionario, int codigoExame);
    void updateExameRealizado(ExameRealizado exameRealizado);
    void deleteExameRealizado(int codigoFuncionario, int codigoExame);
    List<ExameRealizado> getExamesRealizadosPorPeriodo(Date dataInicio, Date dataFim);

}
