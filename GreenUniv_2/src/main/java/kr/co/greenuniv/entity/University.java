package kr.co.greenuniv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.greenuniv.dto.UnivDTO;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "University")
public class University {

    @Id
    private String univName;

    private String univEngName;
    private String univIntroTitle;
    private String univIntroContent;
    private String univIntroFile;
}
