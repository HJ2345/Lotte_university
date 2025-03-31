package kr.co.greenuniv.dto;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {


    private int S_num;
    private String S_name;
    private String S_Ename;
    private String gender;
    private String S_nation;
    private String S_hp;
    private String S_email;
    private String S_addr1;
    private String S_addr2;
    private String S_residentId;

    private int admissionYear;
    private String admissionType;
    private String admissionGrade;
    private String admissionSemester;
    private int graduationYear;


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
