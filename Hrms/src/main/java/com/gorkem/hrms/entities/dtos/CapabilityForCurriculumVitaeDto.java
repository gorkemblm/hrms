package com.gorkem.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapabilityForCurriculumVitaeDto {

    private int curriculumVitaeId;
    private String capabilityType;
    private String capabilityName;
}
