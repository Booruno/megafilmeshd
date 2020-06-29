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

public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;

    String nomeCliente;
    String sobrenomeCliente;
    Long cpfCLiente;
    String nacionalidadeCliente;
    String sexoCliente;

}