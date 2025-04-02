package kr.co.greenuniv.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="course")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cor_code")
    private int cor_code;

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
