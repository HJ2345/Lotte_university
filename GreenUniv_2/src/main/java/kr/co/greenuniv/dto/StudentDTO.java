package kr.co.greenuniv.dto;


import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StudentDTO {


    private String S_name;
    private String S_Ename;
    private String gender;
    private String S_addr1;
    private String S_addr2;
    private String S_nation;
    private String S_hp;
    private String S_email;
    private String S_residentId;

    private String status;  // 재학생 휴학생 대학원생 졸업

    private int admissionYear;
    private int graduationYear;

    private String admissionType;
    private String admissionGrade;
    private String admissionSemester;

    private String univName;
    private String deptNo;
    private String profNo;




}
