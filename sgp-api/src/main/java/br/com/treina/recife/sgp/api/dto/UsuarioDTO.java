package br.com.treina.recife.sgp.api.dto;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusUsuario;

public record UsuarioDTO(
    Long id,
    String cpf,
    String nome,
    String email,
    LocalDate dataNascimento,
    Integer idade,
    StatusUsuario status

) {
}