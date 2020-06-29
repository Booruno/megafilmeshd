package br.edu.usj.ads.lpii.testes.provafinal.megafilmeshd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ContatoController {
   
    @GetMapping(value = "/indexContatos")
    public ModelAndView getContato() {
        // listar todos os clientes
        ModelAndView modelAndView = new ModelAndView("indexContatos");

        return modelAndView;
    }
}
