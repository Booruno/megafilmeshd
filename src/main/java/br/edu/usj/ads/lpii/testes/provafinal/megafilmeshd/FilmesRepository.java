package br.edu.usj.ads.lpii.testes.provafinal.megafilmeshd;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FilmesRepository extends CrudRepository<Filmes, Long> {
    List<Filmes> findAll();
        
}