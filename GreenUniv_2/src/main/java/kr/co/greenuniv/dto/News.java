package kr.co.greenuniv.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {

    private int CnewsId;
    private String title;
    private String content;
    private String writer;
    private int hit;
    private int sort;

    @CreationTimestamp
    private LocalDateTime wdate;

}
