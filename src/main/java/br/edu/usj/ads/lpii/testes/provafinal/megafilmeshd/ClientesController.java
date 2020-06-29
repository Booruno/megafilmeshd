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
public class ClientesController {
    @Autowired
    ClientesRepository clientesRepository;

    @GetMapping(value = "/indexClientes")
    public ModelAndView getListarClientes() {
        // listar todos os clientes
        List<Clientes> lista = clientesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexClientes");
        modelAndView.addObject("lista", lista);

        return modelAndView;
    }

    @GetMapping(value = "/mostrarClientes/{id}")
    public ModelAndView getMostrarClientes(@PathVariable Long id) {
        // mostrar cliente referente ao id
        Clientes clientes = clientesRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("mostrarClientes");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrarClientes")
    public ModelAndView getCadastrarClientes() {
        // retorna o formulario pro usuario preencher
        Clientes clientes = new Clientes();
        ModelAndView modelAndView = new ModelAndView("cadastrarClientes");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrarClientes")
    public ModelAndView postCadastrarClientes(Clientes clientes) {
        // recebe o cliente preenchido no formulario e grava no banco
        clientesRepository.save(clientes);

        ModelAndView modelAndView = new ModelAndView("mostrarClientes");
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping(value = "/deletarClientes/{id}")
    public ModelAndView getDeletarClientes(@PathVariable Long id) {
        // deleta o cliente referente ao id
        clientesRepository.deleteById(id);
        List<Clientes> lista = clientesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexClientes");
        modelAndView.addObject("lista", lista);

        return modelAndView;
    }

    @GetMapping(value = "/editarClientes/{id}")
    public ModelAndView getEditarClientes(@PathVariable Long id) {
        // editar cliente referente ao id, retorna formulário cadastro
        Clientes clientes = clientesRepository.findById(id).get();
        
        ModelAndView modelAndView = new ModelAndView("cadastrarClientes");
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

}