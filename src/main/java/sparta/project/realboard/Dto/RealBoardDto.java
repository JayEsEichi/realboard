package sparta.project.realboard.Dto;

import lombok.*;
import sparta.project.realboard.Entity.RealBoard;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class RealBoardDto {
    private String title;
    private String writer;
    private String password;
    private String content;

    public RealBoard toEntity(){
        return RealBoard.builder()
                .title(title)
                .writer(writer)
                .password(password)
                .content(content)
                .build();
    }

    public RealBoardDto(String title, String writer, String password, String content) {
                RealBoardDto.builder()
                .title(title)
                .writer(writer)
                .password(password)
                .content(content)
                .build();
    }
}
