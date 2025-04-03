package kr.co.greenuniv.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="course")
public class Course {


    @Id
    @Column(name = "cor_code")
    private String cor_code;    // 과목코드
    private String cor_grade;
    private String semester;

    private String cor_type;    // 이수구분
    private String cor_lecName; // 강의명
    private String cor_description; // 강의 설명


    // 대학선택
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univName")
    private University university;

    //전공 선택
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptNo")
    private Department department;

    private String cor_point;
    private String cor_professor;


    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String cor_evalMethod;
    private String cor_book;
    private String cor_class;
    private String cor_maxEnrolment;



    private String lectureDays;



}
