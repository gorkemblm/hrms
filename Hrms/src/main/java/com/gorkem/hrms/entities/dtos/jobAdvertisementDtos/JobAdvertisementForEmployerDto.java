package com.gorkem.hrms.entities.dtos.jobAdvertisementDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForEmployerDto {

    private int employerId;

    private String occupation;

    private String jobDescription;

    private String city;

    private int numberOfOpenPosition;

    private LocalDate applicationDeadline;
}
