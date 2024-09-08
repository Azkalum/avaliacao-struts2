package com.seuprojeto.service.impl;

import com.seuprojeto.dao.IExameDAO;
import com.seuprojeto.model.Exame;
import com.seuprojeto.service.IExameService;

import java.util.List;

public class ExameServiceImpl implements IExameService {

    private IExameDAO exameDAO;

    public ExameServiceImpl(IExameDAO exameDAO) {
        this.exameDAO = exameDAO;
    }

    @Override
    public void addExame(Exame exame) {
        exameDAO.save(exame);
    }

    @Override
    public List<Exame> getAllExames() {
        return exameDAO.findAll();
    }

    @Override
    public Exame getExameById(int id) {
        return exameDAO.findById(id);
    }

    @Override
    public void updateExame(Exame exame) {
        exameDAO.update(exame);
    }

    @Override
    public void deleteExame(int id) {
        exameDAO.delete(id);
    }

    @Override
    public List<Exame> getExamesByStatus(Boolean ativo) {
        return exameDAO.findByStatus(ativo);
    }

    @Override
    public List<Exame> getExamesByNome(String nome) {
        return exameDAO.findByNome(nome);
    }

    @Override
    public Exame getExameByCodigo(int id) {
        return exameDAO.findByCodigo(id);
    }
}
