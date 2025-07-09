package com.pibd.educacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Escola;
import com.pibd.educacao.repository.EscolaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class EscolaService {
    @Autowired
    private  EscolaRepository repository;
    @PersistenceContext
    private EntityManager em;

    public List<Escola> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Escola save(Escola escola) {
        em.persist(escola);
        return escola;
    }

    public Optional<Escola> getById(Long id){
        return repository.findById(id);
    }
}
