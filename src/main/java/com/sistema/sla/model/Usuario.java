package com.sistema.sla.model;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String perfil; // Vai armazenar "ALUNO" ou "PROFESSOR" da tabela de Perfis

    // Construtor vazio
    public Usuario() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
}