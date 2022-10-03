package sparta.project.realboard.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.project.realboard.Dto.RealBoardDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class RealBoard{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition="TEXT",nullable = false)
    private String content;

    @Column
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column
    public LocalDateTime modifiedDate;

    @Builder
    public RealBoard(String title, String writer, String password, String content){
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.content = content;

    }

    public void update(RealBoardDto boarddto){
        this.title = boarddto.getTitle();
        this.writer = boarddto.getWriter();
        this.password = boarddto.getPassword();
        this.content = boarddto.getContent();
        this.modifiedDate = LocalDateTime.now();
    }


}