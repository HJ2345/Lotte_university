package kr.co.greenuniv.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {



    private int cor_code;    // 과목코드

    private String cor_grade;
    private String cor_lecName;
    private String cor_description;
    private String cor_selectMajor;

    private String cor_evalMethod;
    private String cor_point;
    private String cor_professor;
    private String cor_book;
    private String cor_class;
    private String cor_maxEnrolment;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private String lectureDays;


}

