package com.josericardo.seasolutions.services;

import org.springframework.stereotype.Service;

import com.josericardo.seasolutions.models.Trabalhador;
import com.josericardo.seasolutions.repositories.TrabalhadorRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhadorService {
    final TrabalhadorRepository trabalhadorRepository;

    public TrabalhadorService(TrabalhadorRepository trabalhadorRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
    }

    @Transactional
    public Trabalhador adicionarTrabalhador(Trabalhador trabalhador) {
        return trabalhadorRepository.save(trabalhador);
    }

    public List<Trabalhador> procurarTodosTrabalhadores() {
        return trabalhadorRepository.findAll();
    }

    public Trabalhador atualizarTrabalhador(Trabalhador trabalhador) {
        return trabalhadorRepository.save(trabalhador);
    }

    public Optional<Trabalhador> procurarTrabalhadorPorId(Long id) {
        return trabalhadorRepository.findById(id);
    }

    public void deletarTrabalhador(Trabalhador trabalhador) {
        trabalhadorRepository.delete(trabalhador);
    }

    public boolean existsTrabalhadorByCpf(String cpf) {
        return trabalhadorRepository.existsTrabalhadorByCpf(cpf);
    }
}
