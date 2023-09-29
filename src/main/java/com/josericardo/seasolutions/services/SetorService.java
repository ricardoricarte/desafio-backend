package com.josericardo.seasolutions.services;

import org.springframework.stereotype.Service;

import com.josericardo.seasolutions.models.Setor;
import com.josericardo.seasolutions.repositories.CargoRepository;
import com.josericardo.seasolutions.repositories.SetorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    
    final SetorRepository setorRepository;

    final CargoRepository cargoRepository;
    
    public SetorService(SetorRepository setorRepository, CargoRepository cargoRepository) {
        this.setorRepository = setorRepository;
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public Setor adicionarSetor(Setor setor){
      return setorRepository.save(setor);
    }
    public List<Setor> procurarTodosSetores() {
      return setorRepository.findAll();
    }
    public Setor atualizarSetor(Setor setor){
      return setorRepository.save(setor);
    }
    public Optional<Setor> procurarSetorPorId(Long id) {
        return setorRepository.findById(id);
    }
    public void deletarSetor(Setor setor) {
      setorRepository.delete(setor);
    }
    public boolean existsById(Long id) {
        return setorRepository.existsById(id);
    }

}
