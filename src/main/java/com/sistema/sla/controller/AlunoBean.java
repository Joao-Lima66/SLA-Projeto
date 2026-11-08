package com.sistema.sla.controller;

import com.sistema.sla.dao.AlocacaoDao;
import com.sistema.sla.model.Alocacao;
import com.sistema.sla.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

    private Usuario alunoLogado;
    private List<Alocacao> alocacoes;

    @Autowired
    private AlocacaoDao alocacaoDao;

    @PostConstruct
    public void init() {
        alunoLogado = (Usuario) FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().get("usuarioLogado");
        if (alunoLogado != null) {
            alocacoes = alocacaoDao.buscarPorUsuarioId(alunoLogado.getId());
        }
    }

    public Usuario getAlunoLogado() { return alunoLogado; }
    public List<Alocacao> getAlocacoes() { return alocacoes; }
}