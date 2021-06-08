package com.gorkem.hrms.entities.dtos.curriculumVitaeDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapabilityForCurriculumVitaeDto {

    private int jobSeekerId;

    private String capabilityType;

    private String capabilityName;
}
