package sparta.project.realboard.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.project.realboard.Dto.RealBoardDto;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RealBoard {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;


    RealBoard(String title, String writer, String password, String content){
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.content = content;
    }


    RealBoard(RealBoardDto boarddto){
        this.title = boarddto.getTitle();
        this.writer = boarddto.getWriter();
        this.password = boarddto.getPassword();
        this.content = boarddto.getContent();
    }
}