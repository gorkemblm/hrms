package com.gorkem.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolForCurriculumVitaeDto {

    private int curriculumVitaeId;
    private String schoolName;
    private String department;
    private LocalDate startedDateSchool;
    private LocalDate finishedDateSchool;
    private boolean graduationStatus;
}
