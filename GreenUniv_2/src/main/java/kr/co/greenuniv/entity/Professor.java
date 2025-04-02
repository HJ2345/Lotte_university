package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="professor")
public class Professor {

    @Id
    private String P_num;


    private String P_Pnum;
    private String P_name;
    private String P_Ename;
    private String P_gender;
    private String P_nation;
    private String P_hp;
    private String P_email;
    private String P_zip;
    private String P_addr1;
    private String P_addr2;

    private String P_graduniv;
    private String P_spec;
    private String P_graddate;
    private String P_degree;
    private String P_appointdate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "P_lesson")
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "P_spec2")   // 학과 번호
    private Department department;


}


