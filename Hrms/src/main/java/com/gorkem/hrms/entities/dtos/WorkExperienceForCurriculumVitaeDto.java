package com.gorkem.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceForCurriculumVitaeDto {

    private int curriculumVitaeId;
    private String companyName;
    private String position;
    private LocalDate startedDateJob;
    private LocalDate finishedDateJob;
    private boolean isStillWork;
}
