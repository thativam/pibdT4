package com.pibd.educacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Aluno;
import com.pibd.educacao.domain.Turma;
import com.pibd.educacao.domain.dto.TurmaDto;
import com.pibd.educacao.repository.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private EscolaService escolaService;

    @Autowired
    private ProfessorService professorService;

    public Turma save(TurmaDto dto){
        Turma nova = new Turma();
        nova.setAno(dto.getAno());
        nova.setEscola(escolaService.getById(dto.getEscolaId()).get());
        nova.setProfessor(professorService.getById(dto.getProfessorId()).get());
        nova.setSala(dto.getSala());
        nova.setVagas(dto.getVagas());
        return turmaRepository.save(nova);
    }
    
    public List<Turma> findAll(){
        return turmaRepository.findAll();
    }

    public Optional<Turma> getById(Long id){
        return turmaRepository.findById(id);
    }
}
