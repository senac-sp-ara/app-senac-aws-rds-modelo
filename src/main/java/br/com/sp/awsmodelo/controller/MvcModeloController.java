package br.com.sp.awsmodelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.sp.awsmodelo.mapper.PessoaMapper;
import br.com.sp.awsmodelo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MvcModeloController {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pessoas", pessoaMapper.toDtoList(pessoaRepository.findAll()));
        return "index";
    }

}
