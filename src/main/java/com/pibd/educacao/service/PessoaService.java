package com.pibd.educacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Pessoa;
import com.pibd.educacao.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
