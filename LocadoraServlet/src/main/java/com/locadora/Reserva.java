package com.locadora;

import java.util.Date;

public class Reserva {
    private String cliente;
    private String veiculo;
    private String dataInicio;
    private String dataFim;

    public Reserva(String Cliente, String Veiculo,String dataInicio, String dataFim) {
        this.cliente = Cliente;
        this.veiculo = Veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
