package com.pibd.educacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Aluno;
import com.pibd.educacao.domain.Desempenho;
import com.pibd.educacao.repository.DesempenhoRepository;

@Service
public class DesempenhoService {
    
    @Autowired
    private DesempenhoRepository repository;

    public Desempenho addAluno(Desempenho de){
        return repository.save(de);
    }

    public List<Aluno> getByTurma(Long turmaId){
        return repository.getByTurma(turmaId);
    }
}
