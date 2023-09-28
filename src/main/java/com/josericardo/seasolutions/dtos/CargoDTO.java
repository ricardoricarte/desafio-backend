package com.josericardo.seasolutions.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {

    private Long id;
    private String nome;
    private SetorDTO setorDTO;
    private TrabalhadorDTO trabalhadorDTO;
}