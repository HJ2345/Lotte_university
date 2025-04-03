package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentListDTO {
    private String deptNo;         // 학과번호
    private String univName;       // 단과대학명
    private String deptName;       // 학과명
    private String deptChief;      // 학과장 이름 (String)
    private String deptHp;        // 학과 연락처
    private int professorCount;    // 소속 교수 수
    private int studentCount;      // 소속 학생 수
    private int courseCount;       // 개설 강의 수
}