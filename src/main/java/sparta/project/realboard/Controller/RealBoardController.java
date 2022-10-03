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
@RequestMapping("/api")
public class RealBoardController {

    final private RealBoardRepository realBoardRepository;
    final private RealBoardService realBoardService;

    //조회
    @GetMapping("/boards")
    public ApiResult<List<RealBoardResponseDto>> list() {
        return ApiUtils.success(realBoardService.contentlist());
    }

    // 게시글 하나 조회
    @GetMapping("/boards/{id}")
    public ApiResult<RealBoard> viewonecontent(@PathVariable Long id){ // @PathVariable : Mapping url 에 담은 {} value 값을 명시해준것. 반드시 써야함
        return ApiUtils.success(realBoardService.viewcontent(id));
    }

    // 생성
    @PostMapping("/boards")
    public ApiResult<Long> writecontent(@RequestBody RealBoardDto realBoardDto){
        return ApiUtils.success(realBoardService.writecontent(realBoardDto));
    }

    // 수정
    @PutMapping("/boards/{id}")
    public ApiResult<Long> updatecontent(@PathVariable Long id, @RequestBody RealBoardDto realBoardDto) {
        return ApiUtils.success(realBoardService.updatecontent(id, realBoardDto));
    }


    @GetMapping("/boards/{id}/{password}")
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
    @DeleteMapping("/boards/{id}")
    public void deletecontent(@PathVariable Long id){
        realBoardRepository.deleteById(id);
    }

    @RequestMapping("/error")
    public ApiResult failApiFormat(){
        return ApiUtils.error("error",400);
    }

}
