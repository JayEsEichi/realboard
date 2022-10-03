package sparta.project.realboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import sparta.project.realboard.Entity.Timestamped;


@EnableJpaAuditing
@SpringBootApplication
public class RealboardApplication extends Timestamped {

    public static void main(String[] args) {
        SpringApplication.run(RealboardApplication.class, args);
        System.out.println("확인~~");
    }
/*
    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
//            repository.save(new RealBoard("개발의 길", "진세훈", "wls1234", "개발의 길은 멀고도 험하구나"));
//            repository.save(new RealBoard("개발의 늪", "세훈진", "wls123", "개발의 늪은 깊고도 끈적구나"));
//            repository.save(new RealBoard("개발의 숲", "훈진세", "wls12", "개발의 숲은 한없이 넓구나"));// 데이터 저장하기
//            repository.save(new RealBoard("멸망의 길", "진세훈", "wls1", "멸망의 길은 바로 이런 것"));
//            repository.save(new RealBoard("멸망의 길2", "진세훈", "wls1", "멸망의 길은 바로 이런 것"));
//            repository.save(new RealBoard("멸망의 길3", "진세훈", "wls1", "멸망의 길은 바로 이런 것"));

            // 데이터 전부 조회하기
//            List<RealBoard> boardList = repository.findAll();
//            for (int i = 0; i < boardList.size(); i++) {
//                RealBoard realBoard = boardList.get(i);
//                System.out.println(realBoard.getId());
//                System.out.println(realBoard.getTitle());
//                System.out.println(realBoard.getWriter());
//                System.out.println();
//            }

//            System.out.println("경계선");

//            RealBoardDto realBoardDto = new RealBoardDto("신파극", "작가", "1010", "신과함께 호옵");
//
//            realBoardService.updatecontent(3L, realBoardDto);

//            boardList = repository.findAll();
//            for (int i = 0; i < boardList.size(); i++) {
//                RealBoard realBoard = boardList.get(i);
//                System.out.println(realBoard.getTitle());
//                System.out.println(realBoard.getWriter());
//                System.out.println();
//            }


            // 삭제
            //repository.deleteById(2L);

            // 데이터 하나 조회하기
//            RealBoard realBoard = repository.findById(3L).orElseThrow(
//                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//            );
        };
    }
*/
}
