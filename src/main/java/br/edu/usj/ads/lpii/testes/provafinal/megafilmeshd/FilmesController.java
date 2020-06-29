package br.edu.usj.ads.lpii.testes.provafinal.megafilmeshd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class FilmesController {
    @Autowired
    FilmesRepository filmesRepository;

    @GetMapping(value = "/indexFilmes")
    public ModelAndView getListarFilmes() {
        // listar todos os filmes
        List<Filmes> lista = filmesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexFilmes");
        modelAndView.addObject("lista", lista);

        return modelAndView;
    }

    @GetMapping(value = "/mostrarFilmes/{id}")
    public ModelAndView getMostrarFilmes(@PathVariable Long id) {
        // mostrar filmes referente ao id
        Filmes filmes = filmesRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("mostrarFilmes");
        modelAndView.addObject("filmes", filmes);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrarFilmes")
    public ModelAndView getCadastrarFilmes() {
        // retorna o formulario pro usuario preencher
        Filmes filmes = new Filmes();
        ModelAndView modelAndView = new ModelAndView("cadastrarFilmes");
        modelAndView.addObject("filmes", filmes);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrarFilmes")
    public ModelAndView postCadastrarFilmes(Filmes filmes) {
        // recebe o filme preenchido no formulario e grava no banco
        filmesRepository.save(filmes);

        ModelAndView modelAndView = new ModelAndView("mostrarFilmes");
        modelAndView.addObject("filmes", filmes);

        return modelAndView;
    }

    @GetMapping(value = "/deletarFilmes/{id}")
    public ModelAndView getDeletarFilmes(@PathVariable Long id) {
        // deleta o filme referente ao id
        filmesRepository.deleteById(id);
        List<Filmes> lista = filmesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexFilmes");
        modelAndView.addObject("lista", lista);

        return modelAndView;
    }

    @GetMapping(value = "/editarFilmes/{id}")
    public ModelAndView getEditarFilmes(@PathVariable Long id) {
        // editar filme referente ao id, retorna formulário cadastro
        Filmes filmes = filmesRepository.findById(id).get();
        
        ModelAndView modelAndView = new ModelAndView("cadastrarFilmes");
        modelAndView.addObject("filmes", filmes);

        return modelAndView;
    }

}