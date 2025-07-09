package com.pibd.educacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Aluno;
import com.pibd.educacao.repository.AlunoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Aluno save(Aluno aluno) {
        em.persist(aluno);
        return aluno;
    }

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Optional<Aluno> getById(Long id){
        return repository.findById(id);
    }

    public List<Aluno> getAllDisponiveis(){
        return repository.getAlunosDisponiveis();
    }
}
