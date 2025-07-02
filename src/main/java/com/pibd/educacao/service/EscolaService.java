package com.pibd.educacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Escola;
import com.pibd.educacao.repository.EscolaRepository;

@Service
public class EscolaService {
    @Autowired
    private  EscolaRepository repository;


    public List<Escola> findAll() {
        return repository.findAll();
    }
}
