package com.pibd.educacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pibd.educacao.domain.Escola;
import com.pibd.educacao.domain.Pessoa;
import com.pibd.educacao.domain.dto.EscolaDto;
import com.pibd.educacao.service.EscolaService;
import com.pibd.educacao.service.PessoaService;

@Controller
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private PessoaService pService;

    @Autowired
    private EscolaService eService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute EscolaDto escolaDto) {
       // 1. Create and save Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(escolaDto.nome());
        pessoa.setEndereco(escolaDto.endereco());
        pessoa.setDtNascimento(escolaDto.dtNascimento());
        pessoa.setDocumento(escolaDto.documento());
        pessoa.setTelefone(escolaDto.telefone());

        Pessoa savedPessoa = pService.save(pessoa);

        // 2. Create and save Escola
        Escola escola = new Escola();
        escola.setPessoa(savedPessoa);
        escola.setEscolaId(savedPessoa.getId()); // due to @MapsId
        escola.setPeriodo(escolaDto.periodo());
        escola.setInclusao(escolaDto.inclusao());
        escola.setParticular(escolaDto.particular());

        eService.save(escola);
        return "redirect:/";
    }

    @GetMapping("/nova")
    public String novaEscola(Model model) {
        model.addAttribute("escolaDto", new EscolaDto("", "", null, "", "", "", false, false));
        return "escolas/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        //escolaRepo.deleteById(id);
        //pService.deleteById(id);
        return "redirect:/escolas";
    }

}
