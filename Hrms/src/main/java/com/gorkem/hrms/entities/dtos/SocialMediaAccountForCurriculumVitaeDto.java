package com.gorkem.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaAccountForCurriculumVitaeDto {

    private int curriculumVitaeId;
    private String type;
    private String url;
}
