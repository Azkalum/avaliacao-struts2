package com.seuprojeto.action;

import com.seuprojeto.dao.impl.ExameRealizadoDAOImpl;
import com.seuprojeto.model.ExameRealizado;
import com.seuprojeto.service.IExameRealizadoService;
import com.seuprojeto.service.impl.ExameRealizadoServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class RelatorioExamesAction {

    private IExameRealizadoService exameRealizadoService;
    private String dataInicial;
    private String dataFinal;
    private List<ExameRealizado> examesRealizados;

    public RelatorioExamesAction() {
        this.exameRealizadoService = new ExameRealizadoServiceImpl(new ExameRealizadoDAOImpl());
    }

    public String gerarRelatorio() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dataInicio = sdf.parse(dataInicial);
            Date dataFim = sdf.parse(dataFinal);

            examesRealizados = exameRealizadoService.getExamesRealizadosPorPeriodo(dataInicio, dataFim);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public IExameRealizadoService getExameRealizadoService() {
        return exameRealizadoService;
    }

    public void setExameRealizadoService(IExameRealizadoService exameRealizadoService) {
        this.exameRealizadoService = exameRealizadoService;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<ExameRealizado> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(List<ExameRealizado> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }
}
