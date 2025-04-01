package kr.co.greenuniv.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorDTO {

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

    public void setP_num(String p_num) {
        if(p_num != null){
            P_num = Integer.parseInt(p_num);
        }

    }
}
