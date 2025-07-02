package com.pibd.educacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pibd.educacao.domain.Pessoa;
import com.pibd.educacao.domain.Professor;
import com.pibd.educacao.domain.dto.EscolaDto;
import com.pibd.educacao.domain.dto.ProfessorDto;
import com.pibd.educacao.service.PessoaService;
import com.pibd.educacao.service.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private PessoaService pService;

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ProfessorDto escolaDto) {
       // 1. Create and save Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(escolaDto.nome());
        pessoa.setEndereco(escolaDto.endereco());
        pessoa.setDtNascimento(escolaDto.dtNascimento());
        pessoa.setDocumento(escolaDto.documento());
        pessoa.setTelefone(escolaDto.telefone());

        Pessoa savedPessoa = pService.save(pessoa);

        // 2. Create and save Escola
        Professor prof = new Professor();
        prof.setPessoa(savedPessoa);
        prof.setProfId(savedPessoa.getId()); // due to @MapsId
        prof.setSalario(escolaDto.salario());

        professorService.save(prof);
        return "redirect:/";
    }

    @GetMapping("/nova")
    public String novoProf(Model model) {
        model.addAttribute("professorDto", new ProfessorDto("", "", null, "", "", null));
        return "professor/form";
    }
}
