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
import com.pibd.educacao.repository.PessoaRepository;
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
    public String salvar(@ModelAttribute Pessoa pessoa, @ModelAttribute Escola escola) {
        Pessoa savedPessoa = pService.save(pessoa);
        Escola nEscola = new Escola();
        nEscola.setPessoa(savedPessoa);
        nEscola.setEscolaId(savedPessoa.getId());
        nEscola.setPeriodo(escola.getPeriodo());
        nEscola.setInclusao(escola.getInclusao());
        nEscola.setParticular(escola.getParticular());
        eService.save(nEscola);
        return "redirect:/escolas";
    }

    @GetMapping("/nova")
    public String novaEscola(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("escola", new Escola());
        return "escolas/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        //escolaRepo.deleteById(id);
        //pService.deleteById(id);
        return "redirect:/escolas";
    }

}
