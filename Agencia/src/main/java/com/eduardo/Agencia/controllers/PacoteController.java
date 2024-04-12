package com.eduardo.Agencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.eduardo.Agencia.models.Pacotes;
import com.eduardo.Agencia.repository.PacotesRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PacoteController {
    
    @Autowired
    private PacotesRepository pr;

    // Cadastro de pacotes
    @RequestMapping(value = "/cadastrarPacote", method=RequestMethod.GET)
    public String form() {
       return "pacote/formPacote";
    }

    @RequestMapping(value = "/cadastrarPacote", method=RequestMethod.POST)
    public String form(@Validated Pacotes pacote, BindingResult result, RedirectAttributes attributes) {
        
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem_erro", "Verifique os campos!");
            return "redirect:/cadastrarPacote";
        }
        pr.save(pacote);
        attributes.addFlashAttribute("mensagem", "Pacote cadastrado com sucesso!");
        return "redirect:/cadastrarPacote";
    }
    
}
