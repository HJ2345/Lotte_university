package kr.co.greenuniv.dto;

import kr.co.greenuniv.entity.University;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnivDTO {

    private String univName;
    private String univEngName;
    private String univIntroTitle;
    private String univIntroContent;
    private String univIntroFile;
}
