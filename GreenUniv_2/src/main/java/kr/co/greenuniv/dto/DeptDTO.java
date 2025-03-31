package kr.co.greenuniv.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.entity.University;
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
