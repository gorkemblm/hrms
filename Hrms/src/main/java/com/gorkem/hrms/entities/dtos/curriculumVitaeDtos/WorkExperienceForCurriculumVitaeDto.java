package com.gorkem.hrms.entities.dtos.curriculumVitaeDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceForCurriculumVitaeDto {

    private int curriculumVitaeId;

    @NotBlank(message = "Company name cannot be empty")
    @Size(max = 256)
    private String companyName;

    @NotBlank(message = "Position cannot be empty")
    @Size(max = 128)
    private String position;

    @PastOrPresent
    private LocalDate startedDateJob;

    private LocalDate finishedDateJob;

    private boolean isStillWork;
}
