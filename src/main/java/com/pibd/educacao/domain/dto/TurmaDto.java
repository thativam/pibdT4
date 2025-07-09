package com.pibd.educacao.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TurmaDto{
    Long escolaId; 
    Long professorId;
    Integer sala;
    Integer ano;
    Integer vagas;
} 
