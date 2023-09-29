package com.josericardo.seasolutions.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.josericardo.seasolutions.models.Cargo;
import com.josericardo.seasolutions.models.Setor;
import com.josericardo.seasolutions.models.Trabalhador;
import com.josericardo.seasolutions.repositories.TrabalhadorRepository;
import com.josericardo.seasolutions.services.TrabalhadorService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TrabalhadorServiceTest {
    public static final Long ID = 1L;
    public static final String NOME = "Jose Ricardo";
    public static final String CPF = "11111111111";
    public static final Setor SETOR = new Setor();
    public static final Cargo CARGO = new Cargo();

    @InjectMocks
    TrabalhadorService service;

    @Mock
    TrabalhadorRepository repository;

    @Test
    @DisplayName("Deve salvar novo trabalhador.")
    void adicionarTrabalhador() {

        List<Cargo> cargos = new ArrayList<>();
        Trabalhador trabalhador = new Trabalhador();

        SETOR.setNome(NOME);
        SETOR.setId(ID);
        SETOR.setCargos(cargos);
        SETOR.setTrabalhador(trabalhador);

        trabalhador.setId(ID);
        trabalhador.setNome(NOME);
        trabalhador.setCpf(CPF);
        trabalhador.setCargo(CARGO);
        trabalhador.setSetor(SETOR);

        CARGO.setTrabalhador(trabalhador);
        CARGO.setNome(NOME);
        CARGO.setId(ID);

        service.adicionarTrabalhador(trabalhador);

        List<Trabalhador> listaTrabalhadores = new ArrayList<>();
        listaTrabalhadores.add(trabalhador);
        Assertions.assertEquals(1, listaTrabalhadores.size());

    }
}
