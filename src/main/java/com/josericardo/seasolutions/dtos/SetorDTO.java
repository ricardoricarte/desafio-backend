package com.josericardo.seasolutions.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetorDTO {

    private Long id;
    private String nome;
    private List<CargoDTO> cargosDTO;
    private TrabalhadorDTO trabalhadorDTO;
}
