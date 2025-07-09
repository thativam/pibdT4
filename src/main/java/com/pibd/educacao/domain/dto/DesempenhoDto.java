package com.pibd.educacao.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class DesempenhoDto {
    Long alunoId;
    Long turmaId;
}
