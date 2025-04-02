package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Department")
public class Department {

    @Id
    private String deptNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univName")
    private University university;

    private String deptName;
    private String deptEngName;
    private String deptSetDate;

    @Column(name = "deptChief")
    private String deptChief; // 학과장 이름 직접 입력

    private String deptHp;
    private String deptOffice;
}
