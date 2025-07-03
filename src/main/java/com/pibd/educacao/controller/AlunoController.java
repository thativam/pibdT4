package com.pibd.educacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pibd.educacao.domain.Aluno;
import com.pibd.educacao.domain.Pessoa;
import com.pibd.educacao.domain.dto.AlunoDto;
import com.pibd.educacao.service.AlunoService;
import com.pibd.educacao.service.PessoaService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private PessoaService pService;

    @Autowired
    private AlunoService aService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute AlunoDto alunoDto) {
       // 1. Create and save Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(alunoDto.nome());
        pessoa.setEndereco(alunoDto.endereco());
        pessoa.setDtNascimento(alunoDto.dtNascimento());
        pessoa.setDocumento(alunoDto.documento());
        pessoa.setTelefone(alunoDto.telefone());

        Pessoa savedPessoa = pService.save(pessoa);

        // 2. Create and save Escola
        Aluno aluno = new Aluno();
        aluno.setPessoa(savedPessoa);
        aluno.setAlunoId(savedPessoa.getId()); // due to @MapsId
        aluno.setMedia(alunoDto.media());

        aService.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/nova")
    public String novoAluno(Model model) {
        model.addAttribute("alunoDto", new AlunoDto("", "", null, "", "", 0.0));
        return "aluno/form";
    }
}