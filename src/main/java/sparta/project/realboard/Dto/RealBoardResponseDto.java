package sparta.project.realboard.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.project.realboard.Entity.RealBoard;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class RealBoardResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String password;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public RealBoardResponseDto (RealBoard realBoard){
        this.id = realBoard.getId();
        this.title = realBoard.getTitle();
        this.writer = realBoard.getWriter();
        this.password = realBoard.getPassword();
        this.content = realBoard.getContent();
        this.createdDate = realBoard.getCreatedDate();
        this.modifiedDate = realBoard.getModifiedDate();
    }

}
