package com.sistema.sla.controller;

import com.sistema.sla.model.Usuario;
import com.sistema.sla.service.AutenticacaoService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    private String email;
    private String senha;

    @Autowired
    private AutenticacaoService autenticacaoService;

    public String entrar() {
        Usuario usuario = autenticacaoService.validarLogin(email, senha);

        if (usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuarioLogado", usuario);

            if ("ALUNO".equalsIgnoreCase(usuario.getPerfil())) {
                return "/aluno/painel-aluno.xhtml?faces-redirect=true";
            } else if ("PROFESSOR".equalsIgnoreCase(usuario.getPerfil())) {
                return "/professor/painel-professor.xhtml?faces-redirect=true";
            }
        }

        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "E-mail ou senha incorretos!"));
        return null;
    }

    public String deslogar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}