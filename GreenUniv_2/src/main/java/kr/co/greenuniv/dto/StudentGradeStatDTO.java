package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentGradeStatDTO {
    private String grade;        // 학년 (ex: "1학년")
    private long enrolledCount;  // 재학생 수
    private long leaveCount;     // 휴학생 수
    private long totalCount;     // 전체 수
}