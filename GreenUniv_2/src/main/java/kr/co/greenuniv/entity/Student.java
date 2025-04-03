package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="student")
public class Student {

    @Column(name = "S_num", unique = true)
    @Id
    private String S_num; // 학번: 연도 + 학과코드 + 순번

    private String S_name;
    private String S_Ename;
    private String gender;
    private String S_addr1;
    private String S_addr2;
    private String S_nation;
    private String S_hp;
    private String S_email;
    private String S_residentId;

    private int admissionYear;
    private int graduationYear;

    private String admissionType;
    private String admissionGrade;
    private String admissionSemester;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univName")
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptNo")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profNo")
    private Professor professor;


    @Column(name = "status")
    private String status; // 예: 재학, 휴학, 졸업, 대학원






//    private int S_adDate;
//    private int S_gradDate;
//    private String S_adstatus;
//    private String S_lesson;
//    private String S_spec;
//    private String S_grad;
//    private String S_term;
//    private String S_advisor;

//    @ManyToOne
//    @JoinColumn(name = "professor_P_num")
//    private Professor professor;
//
//    @ManyToOne
//    @JoinColumn(name = "department_student")
//    private Department department;


}
