package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Professor2")
public class Professor2 {

    @Id
    private int profNo;
    private String profJumin;
    private String profName;
    private String profEngName;
    private String profGender;
    private String profNationality;
    private String profHp;
    private String profEmail;
    private String profZip;
    private String profAddr1;
    private String profAddr2;
    private String profGradUniv;
    private String profMajor;
    private String profGradDate;
    private String profDegree;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univName")
    private University university;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptName")
    private Department department;

    private String profAppointDate;
}
