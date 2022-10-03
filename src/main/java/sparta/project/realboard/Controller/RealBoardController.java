package sparta.project.realboard.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.project.realboard.Dto.RealBoardDto;
import sparta.project.realboard.Dto.RealBoardResponseDto;
import sparta.project.realboard.Entity.RealBoard;
import sparta.project.realboard.Repository.RealBoardRepository;
import sparta.project.realboard.Service.RealBoardService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RealBoardController {

    final private RealBoardRepository realBoardRepository;
    final private RealBoardService realBoardService;

    //조회
    @GetMapping("/api/boards")
    public List<RealBoardResponseDto> list() {
        return realBoardService.contentlist();
    }

    // 게시글 하나 조회
    @GetMapping("/api/boards/{id}")
    public RealBoard viewonecontent(@PathVariable Long id){ // @PathVariable : Mapping url 에 담은 {} value 값을 명시해준것. 반드시 써야함

        RealBoard realBoard = realBoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return realBoard;
    }

    // 생성
    @PostMapping("/api/boards")
    public Long writecontent(@RequestBody RealBoardDto realBoardDto){
        return realBoardService.writecontent(realBoardDto);
    }


    // 수정
    @PutMapping("/api/boards/{id}")
    public Long updatecontent(@PathVariable Long id, @RequestBody RealBoardDto realBoardDto) {
        return realBoardService.updatecontent(id, realBoardDto);
    }


    @GetMapping("/api/boards/{id}/{password}")
    public RealBoard pwdcheck(@PathVariable Long id,@PathVariable String password){
        RealBoard realBoard = realBoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        if(!realBoard.getPassword().equals(password)){
            System.out.println("불일치하는 비밀번호");
        }else if(realBoard.getPassword().equals(password)){
            System.out.println("일치하는 비밀번호");

        }
        return realBoard;
    }

    // 삭제
    @DeleteMapping("/api/boards/{id}")
    public void deletecontent(@PathVariable Long id){
        realBoardRepository.deleteById(id);
    }

}
