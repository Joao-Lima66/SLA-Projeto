package com.sistema.sla.model;

public class Alocacao {
    private Integer id;
    private String horario;
    private Usuario usuario;
    private Disciplina disciplina; // Conecta com a classe Disciplina
    private Sala sala;             // Conecta com a classe Sala

    public Alocacao() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
}