package com.pibd.educacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pibd.educacao.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    //select * FROM aluno a, desempenho p where a.aluno_id <> p.aluno_id;
    @Query("SELECT a FROM Aluno a WHERE NOT EXISTS (" +
       "SELECT d FROM Desempenho d WHERE d.aluno = a)")
    public List<Aluno> getAlunosDisponiveis();
}
