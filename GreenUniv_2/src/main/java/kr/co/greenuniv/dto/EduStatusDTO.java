package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduStatusDTO {
    private String departmentName;
    private String courseCode;
    private String courseName;
    private String grade;
    private String professorName;
    private String type;         // 전공 or 교양
    private String point;        // 학점
    private String classroom;
    private int enrolledCount;   // 수강인원
    private double enrollmentRate; // 수강률 (더미로)
}
