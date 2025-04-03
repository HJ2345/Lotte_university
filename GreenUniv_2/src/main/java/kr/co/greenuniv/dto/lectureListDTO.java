package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class lectureListDTO {
    private String corCode;       // 과목코드
    private String deptName;      // 학과명
    private String corGrade;      // 학년
    private String corType;       // 구분 (전공/교양)
    private String corLecName;    // 과목명
    private String professorName; // 교수명
    private String corPoint;      // 학점
    private String timeInfo;      // 수업시간
    private String corClass;      // 강의실
    private String corMaxEnrolment; // 최대 수강 인원
}