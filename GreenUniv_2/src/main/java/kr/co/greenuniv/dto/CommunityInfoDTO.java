package kr.co.greenuniv.dto;

import kr.co.greenuniv.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

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
    private int file;

    private String wdate;

    // 추가필드
    private String nick;
    private String regip;

//    private UserDTO user;
//    private List<FileDTO> files;

    public String getWdate() {
        if(wdate != null){
            return wdate.substring(0, 10);
        }
        return null;
    }

//    // 파일 첨부 객체
//    private MultipartFile file1;
//    private MultipartFile file2;
//
//    public List<MultipartFile> getMultipartFiles() {
//        return List.of(file1, file2);
//    }

}
