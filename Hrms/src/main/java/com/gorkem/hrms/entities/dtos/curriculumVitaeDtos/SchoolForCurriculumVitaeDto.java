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
public class SchoolForCurriculumVitaeDto {

    private int curriculumVitaeId;

    @NotBlank(message = "School name cannot be empty")
    @Size(max = 256, message = "School name cannot exceed 255 characters")
    private String schoolName;

    @NotBlank(message = "Department cannot be empty")
    @Size(max = 128, message = "Department name cannot exceed 128 characters")
    private String department;

    @PastOrPresent
    private LocalDate startedDateSchool;

    private LocalDate finishedDateSchool;

    private boolean graduationStatus;
}
