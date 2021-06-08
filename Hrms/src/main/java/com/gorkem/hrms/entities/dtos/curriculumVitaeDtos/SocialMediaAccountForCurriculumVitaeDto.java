package com.gorkem.hrms.entities.dtos.curriculumVitaeDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaAccountForCurriculumVitaeDto {

    private int jobSeekerId;

    private String type;

    private String url;
}
