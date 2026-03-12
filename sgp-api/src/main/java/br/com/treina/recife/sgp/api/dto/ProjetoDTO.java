package br.com.treina.recife.sgp.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.treina.recife.sgp.api.enums.StatusProjeto;
import br.com.treina.recife.sgp.api.model.Usuario;

public record ProjetoDTO(
    Long id,
    String nome,
    String descricao,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCriacao,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataConclusao,
    Integer qtdDias,
    StatusProjeto status,
    Usuario responsavel
) {
} 