package com.sistema.sla.dao;

import com.sistema.sla.model.Alocacao;
import com.sistema.sla.model.Disciplina;
import com.sistema.sla.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlocacaoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Alocacao> buscarPorUsuarioId(Integer usuarioId) {
        String sql = "SELECT a.id, a.horario, d.nome AS disciplina_nome, " +
                     "s.bloco, s.numero, s.tipo " +
                     "FROM alocacao a " +
                     "JOIN disciplina d ON a.disciplina_id = d.id " +
                     "JOIN sala s ON a.sala_id = s.id " +
                     "WHERE a.usuario_id = ?";

        return jdbcTemplate.query(sql, new Object[]{usuarioId}, (rs, rowNum) -> {
            Alocacao alocacao = new Alocacao();
            alocacao.setId(rs.getInt("id"));
            alocacao.setHorario(rs.getString("horario"));
            
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(rs.getString("disciplina_nome"));
            alocacao.setDisciplina(disciplina);
            
            Sala sala = new Sala();
            sala.setBloco(rs.getString("bloco"));
            sala.setNumero(rs.getString("numero"));
            sala.setTipo(rs.getString("tipo")); 
            alocacao.setSala(sala);
            
            return alocacao;
        });
    }
}