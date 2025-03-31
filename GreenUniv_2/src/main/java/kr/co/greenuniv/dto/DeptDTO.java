package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptDTO {

    private String deptNo;
    private String deptName;
    private String deptEngName;
    private String deptSetDate;
    private String deptHp;
    private String deptOffice;
}
