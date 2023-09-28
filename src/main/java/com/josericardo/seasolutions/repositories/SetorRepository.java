package com.josericardo.seasolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josericardo.seasolutions.models.Setor;


@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
    boolean existsById(Long id);
    Setor findSetorById(Long id);

}
