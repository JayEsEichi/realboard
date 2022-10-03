package sparta.project.realboard.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sparta.project.realboard.Dto.RealBoardDto;
import sparta.project.realboard.Dto.RealBoardResponseDto;
import sparta.project.realboard.Entity.RealBoard;
import sparta.project.realboard.Repository.RealBoardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RealBoardService {

    private final RealBoardRepository realBoardRepository;

    // 전체 조회
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public List<RealBoardResponseDto> contentlist() {
        Sort sort = Sort.by(Sort.Direction.DESC,  "createdDate");
        List<RealBoard> list = realBoardRepository.findAll(sort);
        return list.stream().map(RealBoardResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public RealBoard viewcontent(Long id){
        RealBoard realBoard = realBoardRepository.findById(id).orElseThrow();
        return realBoard;
    }

    // 게시글 생성
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long writecontent(RealBoardDto realBoardDto) {
        RealBoard realBoard = realBoardRepository.save(realBoardDto.toEntity());

        return realBoard.getId();
    }

    //
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long updatecontent(Long id, RealBoardDto realBoardDto) {
        RealBoard realBoard = realBoardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        realBoard.update(realBoardDto);
        return realBoard.getId();
    }


}
