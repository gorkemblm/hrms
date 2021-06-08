package com.gorkem.hrms.entities.dtos.curriculumVitaeDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetterForCurriculumVitaeDto {

    private int jobSeekerId;

    @NotBlank(message = "Cover letter cannot exceed 1200 characters")
    @Size(max = 1200)
    private String coverLetter;
}
