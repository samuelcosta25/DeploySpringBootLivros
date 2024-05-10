package br.com.samuelcosta.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.samuelcosta.Model.Livro;
import br.com.samuelcosta.Repository.LivrosRepository;

@Controller
@RestController
public class LivrosController {
    
    @Autowired
    LivrosRepository livrosRepository;

    @GetMapping("/livros")
    public List<Livro> list() {
        return (List<Livro>) this.livrosRepository.findAll();    
    }

    @PostMapping("/livros")
    public Livro create(@RequestBody Livro livro) {
        return this.livrosRepository.save(livro);
    }
    

    

}
