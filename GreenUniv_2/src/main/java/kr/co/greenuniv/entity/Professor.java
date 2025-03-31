package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="professor")
public class Professor {

    @Id
    private int P_num;

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
    private String P_lesson;
    private String P_spec2;
    private String P_appointdate;
}
