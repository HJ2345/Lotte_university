package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "community_infor")
public class CommunityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CinforId;

    private String title;
    private String content;

    //private String writer;
    // 조회수, 조인
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "writer")
    private User user;
    //private String writer;

    private String company;
    private int hit;
    private int status;
    private String deadline;

    private String regip;

    @CreationTimestamp
    private LocalDateTime wdate;


}
