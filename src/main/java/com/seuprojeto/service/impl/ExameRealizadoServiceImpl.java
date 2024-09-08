package com.seuprojeto.service.impl;

import com.seuprojeto.dao.IExameRealizadoDAO;
import com.seuprojeto.model.ExameRealizado;
import com.seuprojeto.service.IExameRealizadoService;

import java.util.Date;
import java.util.List;

public class ExameRealizadoServiceImpl implements IExameRealizadoService {

    private IExameRealizadoDAO exameRealizadoDAO;

    public ExameRealizadoServiceImpl(IExameRealizadoDAO exameRealizadoDAO) {
        this.exameRealizadoDAO = exameRealizadoDAO;
    }

    @Override
    public void addExameRealizado(ExameRealizado exameRealizado) {
        exameRealizadoDAO.save(exameRealizado);
    }

    @Override
    public List<ExameRealizado> getAllExamesRealizados() {
        return exameRealizadoDAO.findAll();
    }

    @Override
    public ExameRealizado getExameRealizadoById(int codigoFuncionario, int codigoExame) {
        return exameRealizadoDAO.findById(codigoFuncionario, codigoExame);
    }

    @Override
    public void updateExameRealizado(ExameRealizado exameRealizado) {
        exameRealizadoDAO.update(exameRealizado);
    }

    @Override
    public void deleteExameRealizado(int codigoFuncionario, int codigoExame) {
        exameRealizadoDAO.delete(codigoFuncionario, codigoExame);
    }

    @Override
    public List<ExameRealizado> getExamesRealizadosPorPeriodo(Date dataInicio, Date dataFim) {
        return exameRealizadoDAO.findByPeriodo(dataInicio, dataFim);
    }
}
