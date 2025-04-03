package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradDTO {
    private String deptChief;
    private String deptHp;
    private String deptName;

    private String univName;
}
