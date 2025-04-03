package kr.co.greenuniv.dto;

import kr.co.greenuniv.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityInfoDTO {

    private int CinforId;

    private String title;
    private String content;
    private String writer;
    private String company;
    private int hit;
    private int status;
    private String deadline;

    private String wdate;

    // 추가필드
    private String nick;
    private String regip;

    public String getWdate() {
        if(wdate != null){
            return wdate.substring(0, 10);
        }
        return null;
    }

}
