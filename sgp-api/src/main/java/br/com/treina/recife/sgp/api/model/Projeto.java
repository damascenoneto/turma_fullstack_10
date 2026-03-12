package br.com.treina.recife.sgp.api.model;

import java.time.LocalDate;
import java.time.Period;

import br.com.treina.recife.sgp.api.dto.ProjetoDTO;
import br.com.treina.recife.sgp.api.enums.StatusProjeto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_PROJETOS")
public class Projeto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataInicio;

    
    private LocalDate dataConclusao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @ManyToOne
    @JoinColumn(nullable = false, name = "usuario_resp_id")
    private Usuario responsavel;

    public ProjetoDTO tDto(){
        Period periodo = Period.between(dataInicio, LocalDate.now());

        

        return new ProjetoDTO(
            id, 
            nome, 
            descricao, 
            dataInicio, 
            dataConclusao,
            periodo.getDays(), 
            status, 
            responsavel
        );
        
        
    }


    
}
