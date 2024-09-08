package com.seuprojeto.model;

public class Usuario {

    private String username;
    private String password;
    private int tempoInatividade;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTempoInatividade() {
        return tempoInatividade;
    }

    public void setTempoInatividade(int tempoInatividade) {
        if (tempoInatividade < 1 || tempoInatividade > 90) {
            throw new IllegalArgumentException("O tempo de inatividade deve estar entre 1 e 90 minutos.");
        }
        this.tempoInatividade = tempoInatividade;
    }

}