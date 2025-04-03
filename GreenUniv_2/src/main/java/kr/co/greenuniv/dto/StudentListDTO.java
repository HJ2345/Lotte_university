package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentListDTO {
    private String sNum;            // 학번
    private String name;            // 이름
    private String residentId;      // 주민번호
    private String phone;           // 휴대폰
    private String email;           // 이메일
    private String deptName;        // 학과
    private String admissionGrade;  // 학년
    private String admissionSemester; // 학기
    private String status;          // 상태 (재학, 휴학, 졸업 등)
}