package com.josericardo.seasolutions.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.josericardo.seasolutions.controllers.SetorController;
import com.josericardo.seasolutions.dtos.SetorDTO;
import com.josericardo.seasolutions.models.Setor;
import com.josericardo.seasolutions.services.SetorService;

@RunWith(MockitoJUnitRunner.class)
public class SetorControllerTest {

    @InjectMocks
    private SetorController setorController;

    @Mock
    private SetorService setorService;

    @Test
    public void salvarSetor_DeveRetornarHttpStatusCreatedQuandoSetorNaoExistir() {
        // Configurar um SetorDTO fictício
        SetorDTO setorDTO = new SetorDTO();
        setorDTO.setId(1L);
        setorDTO.setNome("Setor Teste");

        // Configurar o comportamento do serviço para simular que o setor não existe
        when(setorService.existsById(1L)).thenReturn(false);

        // Configurar o comportamento do serviço para simular a adição bem-sucedida do setor
        Setor novoSetor = new Setor();
        novoSetor.setId(1L);
        novoSetor.setNome("Setor Teste");
        when(setorService.adicionarSetor(any(Setor.class))).thenReturn(novoSetor);

        // Chamar o método salvarSetor no controlador
        ResponseEntity<Object> response = setorController.salvarSetor(setorDTO);

        // Verificar se o método retorna HttpStatus.CREATED e o novo setor
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(novoSetor, response.getBody());
    }

    @Test
    public void salvarSetor_DeveRetornarHttpStatusConflictQuandoSetorExistir() {
        // Configurar um SetorDTO fictício
        SetorDTO setorDTO = new SetorDTO();
        setorDTO.setId(1L);
        setorDTO.setNome("Setor Teste");

        // Configurar o comportamento do serviço para simular que o setor já existe
        when(setorService.existsById(1L)).thenReturn(true);

        // Chamar o método salvarSetor no controlador
        ResponseEntity<Object> response = setorController.salvarSetor(setorDTO);

        // Verificar se o método retorna HttpStatus.CONFLICT e a mensagem de erro esperada
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Erro ao cadastrar novo setor: Setor já existente.", response.getBody());
    }
}