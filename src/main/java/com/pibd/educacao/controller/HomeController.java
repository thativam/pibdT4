package com.pibd.educacao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pibd.educacao.domain.Aluno;
import com.pibd.educacao.domain.Desempenho;
import com.pibd.educacao.domain.DesempenhoId;
import com.pibd.educacao.domain.Escola;
import com.pibd.educacao.domain.Turma;
import com.pibd.educacao.domain.dto.DesempenhoDto;
import com.pibd.educacao.domain.dto.ProfessorDto;
import com.pibd.educacao.domain.dto.TurmaDto;
import com.pibd.educacao.service.AlunoService;
import com.pibd.educacao.service.DesempenhoService;
import com.pibd.educacao.service.EscolaService;
import com.pibd.educacao.service.ProfessorService;
import com.pibd.educacao.service.TurmaService;

@Controller
public class HomeController {

    @Autowired
    private EscolaService escolaService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private DesempenhoService desempenhoService;

    @GetMapping("/")
    public String index(Model model) {
        List<Escola> escolas = escolaService.findAll();
        model.addAttribute("turmaDto", new TurmaDto());
        model.addAttribute("escolas", escolas);
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("turmas", turmaService.findAll());
        model.addAttribute("alunosDisponiveis", alunoService.getAllDisponiveis());
        Map<Long, List<Aluno>> turmas_alunos = new HashMap<>();
        turmaService.findAll().forEach((c) -> {
            turmas_alunos.put(c.getTurmaId(), desempenhoService.getByTurma(c.getTurmaId()));
        });
        model.addAttribute("alunoPorTurma", turmas_alunos);
        // TurmaID -> List<Aluno>;
        return "index";
    }

    @PostMapping("/turmas/salvar")
    public String criarTurma(@ModelAttribute TurmaDto turmaDto){
        turmaService.save(turmaDto);
        return "redirect:/";
    }

    @PostMapping("/turmas/adicionar-aluno")
    public String adicionarAluno(@ModelAttribute DesempenhoDto desempenhoDto){
        Aluno al = alunoService.getById(desempenhoDto.getAlunoId()).get();
        Turma t = turmaService.getById(desempenhoDto.getTurmaId()).get();
        Desempenho desempenho = new Desempenho();
        DesempenhoId id = new DesempenhoId();
        id.setTurmaId(desempenhoDto.getTurmaId());
        id.setAlunoId(desempenhoDto.getAlunoId());
        desempenho.setId(id);
        desempenho.setAluno(al);
        desempenho.setTurma(t);
        desempenhoService.addAluno(desempenho);
        System.out.println(desempenhoDto);
        return "redirect:/";
    }

}
