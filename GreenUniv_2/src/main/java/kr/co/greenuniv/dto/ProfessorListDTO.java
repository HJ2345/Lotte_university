package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorListDTO {
    private String pNum;         // 교수번호
    private String pName;        // 이름
    private String pResidentId;  // 주민번호
    private String pHp;          // 휴대폰
    private String pEmail;       // 이메일
    private String deptName;     // 학과
    private String position;     // 직위 (더미로 처리 가능)
    private String working;      // 재직 여부 (더미)
    private String appointDate;  // 임용일
}