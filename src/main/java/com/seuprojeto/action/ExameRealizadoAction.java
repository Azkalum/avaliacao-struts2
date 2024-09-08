package com.seuprojeto.action;

import com.opensymphony.xwork2.ActionSupport;
import com.seuprojeto.dao.impl.ExameRealizadoDAOImpl;
import com.seuprojeto.model.ExameRealizado;
import com.seuprojeto.service.IExameRealizadoService;
import com.seuprojeto.service.impl.ExameRealizadoServiceImpl;

import java.util.List;

public class ExameRealizadoAction extends ActionSupport {

    private IExameRealizadoService exameRealizadoService;
    private ExameRealizado exameRealizado;
    private List<ExameRealizado> examesRealizados;
    private int codigoFuncionario;
    private int codigoExame;

    public ExameRealizadoAction() {
        this.exameRealizadoService = new ExameRealizadoServiceImpl(new ExameRealizadoDAOImpl());
    }

    public String create() {
        exameRealizadoService.addExameRealizado(exameRealizado);
        return SUCCESS;
    }

    public String list() {
        examesRealizados = exameRealizadoService.getAllExamesRealizados();
        return SUCCESS;
    }

    public String edit() {
        exameRealizado = exameRealizadoService.getExameRealizadoById(codigoFuncionario, codigoExame);
        return SUCCESS;
    }

    public String update() {
        exameRealizadoService.updateExameRealizado(exameRealizado);
        return SUCCESS;
    }

    public String delete() {
        exameRealizadoService.deleteExameRealizado(codigoFuncionario, codigoExame);
        return SUCCESS;
    }

    public IExameRealizadoService getExameRealizadoService() {
        return exameRealizadoService;
    }

    public void setExameRealizadoService(IExameRealizadoService exameRealizadoService) {
        this.exameRealizadoService = exameRealizadoService;
    }

    public ExameRealizado getExameRealizado() {
        return exameRealizado;
    }

    public void setExameRealizado(ExameRealizado exameRealizado) {
        this.exameRealizado = exameRealizado;
    }

    public List<ExameRealizado> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(List<ExameRealizado> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public int getCodigoExame() {
        return codigoExame;
    }

    public void setCodigoExame(int codigoExame) {
        this.codigoExame = codigoExame;
    }
}
