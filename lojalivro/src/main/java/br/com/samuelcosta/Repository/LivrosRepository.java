package br.com.samuelcosta.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.samuelcosta.Model.Livro;

public interface LivrosRepository extends CrudRepository<Livro, Integer>{
    
}
