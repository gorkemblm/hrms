package com.gorkem.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageForCurriculumVitaeDto {

    private int curriculumVitaeId;
    private String language;
    private int level;
}
