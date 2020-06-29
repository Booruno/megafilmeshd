package br.edu.usj.ads.lpii.testes.provafinal.megafilmeshd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;
     
    String nomeFilme;
    String descFilme;
    String diretorFilme;
    String generoFilme;
    String produtoraFilme;
    
}