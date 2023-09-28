package com.josericardo.seasolutions.services;

import org.springframework.stereotype.Service;

import com.josericardo.seasolutions.models.Cargo;
import com.josericardo.seasolutions.repositories.CargoRepository;
import com.josericardo.seasolutions.repositories.SetorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    final CargoRepository cargoRepository;

    final SetorRepository setorRepository;

    public CargoService(CargoRepository cargoRepository, SetorRepository setorRepository) {
        this.cargoRepository = cargoRepository;
        this.setorRepository = setorRepository;
    }

    @Transactional
    public Cargo adicionarCargo(Long id, Cargo cargo) {
        setorRepository.findSetorById(id);
        cargo.setSetor(setorRepository.findSetorById(id));
        return cargoRepository.save(cargo);}

    @Transactional
    public List<Cargo> procurarTodosCargos() {
        setorRepository.findAll();
        return cargoRepository.findAll();
    }

    public Cargo atualizarCargo(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public Optional<Cargo> procurarCargoPorId(Long id) {
        return cargoRepository.findById(id);
    }

    public void deletarCargo(Cargo cargo) {
        cargoRepository.delete(cargo);
    }

    public boolean existsById(Long id) {
        return cargoRepository.existsById(id);
    }


}
