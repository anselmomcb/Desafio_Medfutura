package com.desafio.medfutura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("SELECT p FROM Pessoa p WHERE " +
            "p.apelido LIKE %:termo% OR " +
            "p.nome LIKE %:termo% OR " +
            "EXISTS (SELECT 1 FROM p.stack s WHERE s LIKE %:termo%)")
    List<Pessoa> findByTermo(@Param("termo") String termo);
}