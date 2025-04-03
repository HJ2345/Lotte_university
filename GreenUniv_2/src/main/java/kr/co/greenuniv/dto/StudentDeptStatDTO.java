package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDeptStatDTO {
    private String deptName;       // 학과명
    private long enrolledCount;    // 재학생 수
    private long leaveCount;       // 휴학생 수
    private long totalCount;       // 전체 수 (재학생 + 휴학생)
}