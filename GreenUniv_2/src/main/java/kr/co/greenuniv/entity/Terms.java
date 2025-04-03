package kr.co.greenuniv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Terms")
public class Terms {

    @Id
    private int no;

    @Column(columnDefinition = "TEXT")
    private String terms;

    @Column(columnDefinition = "TEXT")
    private String privacy;

}
