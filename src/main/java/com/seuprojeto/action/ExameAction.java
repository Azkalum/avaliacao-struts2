package com.seuprojeto.action;

import com.opensymphony.xwork2.ActionSupport;
import com.seuprojeto.dao.impl.ExameDAOImpl;
import com.seuprojeto.model.Exame;
import com.seuprojeto.service.IExameService;
import com.seuprojeto.service.impl.ExameServiceImpl;

import java.util.List;

public class ExameAction extends ActionSupport {
    private IExameService exameService;
    private Exame exame;
    private List<Exame> exames;
    private int id;
    private Boolean filtroAtivo;
    private String nome;
    private int codigo;

    public ExameAction() {
        this.exameService = new ExameServiceImpl(new ExameDAOImpl());
    }

    public String create() {
        exameService.addExame(exame);
        return SUCCESS;
    }

    public String list() {
        if (filtroAtivo != null) {
            exames = exameService.getExamesByStatus(filtroAtivo);
        } else if (nome != null && !nome.isEmpty()) {
            exames = exameService.getExamesByNome(nome);
        } else if (codigo > 0) {
            exames = (List<Exame>) exameService.getExameByCodigo(codigo);
        } else {
            exames = exameService.getAllExames();
        }
        return SUCCESS;
    }

    public String edit() {
        exame = exameService.getExameById(id);
        return SUCCESS;
    }

    public String update() {
        exameService.updateExame(exame);
        return SUCCESS;
    }

    public String delete() {
        exameService.deleteExame(id);
        return SUCCESS;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getFiltroAtivo() {
        return filtroAtivo;
    }

    public void setFiltroAtivo(Boolean filtroAtivo) {
        this.filtroAtivo = filtroAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}