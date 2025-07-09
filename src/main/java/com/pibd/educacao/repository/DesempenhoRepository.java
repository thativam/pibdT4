package com.pibd.educacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pibd.educacao.domain.Aluno;
import com.pibd.educacao.domain.Desempenho;

public interface DesempenhoRepository extends JpaRepository<Desempenho, Long> {

    @Query("SELECT d.aluno FROM Desempenho d WHERE d.id.turmaId = :tId")
    public List<Aluno> getByTurma(@Param("tId") Long turmaId);


}
