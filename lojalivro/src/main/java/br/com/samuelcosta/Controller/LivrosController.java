package br.com.samuelcosta.Controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.samuelcosta.Model.Livro;
import br.com.samuelcosta.Repository.LivroRepository;

public class LivrosController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livro")
    public ModelAndView getLivros() {
        ModelAndView mv = new ModelAndView("livros");
        mv.addObject("livros", livroRepository.findAll());
        return mv;
    }

    @GetMapping("addlivros")
    public String getAddLivro(){
        return "livro-add";
    }

    @PostMapping("/addlivros")
    public String postLivro(Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livro";
    }
}
