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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profName")
    private Professor professor;

    private String deptHp;
    private String deptOffice;
}
