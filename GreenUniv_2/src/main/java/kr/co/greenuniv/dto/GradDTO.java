package kr.co.greenuniv.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String deptChief; // 학과장
    private String deptHp;    // 학과 전화번호
    private String deptName;  // 학과명

    private String univName;  // 대학명
}