package com.seuprojeto.service;

import com.seuprojeto.model.Exame;

import java.util.List;

public interface IExameService {

    void addExame(Exame exame);
    List<Exame> getAllExames();
    Exame getExameById(int id);
    void updateExame(Exame exame);
    void deleteExame(int id);
    List<Exame> getExamesByStatus(Boolean ativo);
    List<Exame> getExamesByNome(String nome);
    Exame getExameByCodigo(int id);

}
