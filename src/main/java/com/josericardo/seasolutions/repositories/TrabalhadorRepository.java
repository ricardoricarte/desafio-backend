package com.josericardo.seasolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josericardo.seasolutions.models.Trabalhador;

@Repository
public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {
    boolean existsTrabalhadorByCpf(String cpf);

}
