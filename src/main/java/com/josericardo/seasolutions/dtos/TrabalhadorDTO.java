package com.josericardo.seasolutions.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrabalhadorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private SetorDTO setorDTO;
    private CargoDTO cargoDTO;

}