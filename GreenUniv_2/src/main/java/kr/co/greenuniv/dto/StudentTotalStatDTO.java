package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentTotalStatDTO {
    private long enrolledTotal;   // 총 재학생 수
    private long leaveTotal;      // 총 휴학생 수
    private long totalAll;        // 전체 수 (재학 + 휴학)
}