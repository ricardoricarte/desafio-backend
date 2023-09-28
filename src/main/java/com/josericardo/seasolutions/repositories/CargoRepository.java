package com.josericardo.seasolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josericardo.seasolutions.models.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    boolean existsById(Long id);
    Cargo findCargoByNome(String nome);
}