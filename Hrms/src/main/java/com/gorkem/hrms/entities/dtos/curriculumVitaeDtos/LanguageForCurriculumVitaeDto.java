package com.gorkem.hrms.entities.dtos.curriculumVitaeDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageForCurriculumVitaeDto {

    private int curriculumVitaeId;

    private String language;

    @Size(min = 1, max = 5, message = "Level must be between 1 and 5")
    @Positive
    private int level;
}
