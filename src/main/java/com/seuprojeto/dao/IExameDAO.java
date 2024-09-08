package com.seuprojeto.dao;

import com.seuprojeto.model.Exame;

import java.util.List;

public interface IExameDAO {

    void save(Exame exame);
    List<Exame> findAll();
    Exame findById(int id);
    void update(Exame exame);
    void delete(int id);
    List<Exame> findByStatus(Boolean ativo);
    List<Exame> findByNome(String nome);
    Exame findByCodigo(int id);

}
