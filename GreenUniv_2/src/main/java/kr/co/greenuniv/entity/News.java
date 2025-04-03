package kr.co.greenuniv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "community_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CnewsId;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;
//    private String writer;

    private int hit;
    private int sort;

    @CreationTimestamp
    private LocalDateTime wdate;

}
