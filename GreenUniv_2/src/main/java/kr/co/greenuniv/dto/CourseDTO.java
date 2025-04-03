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



    private String cor_code;    // 과목코드
    private String cor_grade;
    private String semester;    // 학기
    private String cor_type;
    private String cor_lecName; // 강의명
    private String cor_description; // 강의 설명

    private String univName;    // 대학
    private String deptNo;      // 대학 코드

    private String cor_point;
    private String cor_professor;

    private String cor_evalMethod;

    private String cor_book;
    private String cor_class;
    private String cor_maxEnrolment;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private String lectureDays;


}

