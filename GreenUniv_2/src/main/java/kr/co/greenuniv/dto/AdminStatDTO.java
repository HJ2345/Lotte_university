package kr.co.greenuniv.dto;
import lombok.*;
// adminMain 대학운영 현황
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminStatDTO {
    private long departmentCount;
    private long courseCount;
    private long professorCount;
    private long staffCount;    // 현재는 더미
    private long studentCount;
    private long leaveCount;    // 더미
    private long graduateCount; // 더미
    private long graduateSchoolCount; // 대학원생
}
