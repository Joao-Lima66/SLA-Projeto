package com.sistema.sla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.sla.dao.UsuarioDao;
import com.sistema.sla.model.Usuario;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioDao usuarioDao;

    public Usuario validarLogin(String email, String senha) {
        return usuarioDao.buscarPorEmailESenha(email, senha);
    }
}