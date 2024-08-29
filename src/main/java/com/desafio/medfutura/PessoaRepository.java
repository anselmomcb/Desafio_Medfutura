package com.desafio.medfutura;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    List<Pessoa> findByTermo(String apelido, String nome, String stack);
}
