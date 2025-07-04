package com.pibd.educacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pibd.educacao.domain.Escola;
import com.pibd.educacao.service.EscolaService;

@Controller
public class HomeController {

    @Autowired
    private EscolaService escolaService;    

    @GetMapping("/")
    public String index(Model model) {
        List<Escola> escolas = escolaService.findAll();
        return "index";
    }

}
