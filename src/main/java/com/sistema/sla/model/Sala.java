package com.sistema.sla.model;

public class Sala {
    private Integer id;
    private String bloco;
    private String numero;
    private String tipo; // Vai armazenar "TEORICA" ou "LABORATORIO"

    public Sala() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}