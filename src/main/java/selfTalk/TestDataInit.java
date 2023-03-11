package selfTalk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import selfTalk.domain.customer.*;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
   private final CustomerRepository itemRepository;
    private final PersonalityRepository personalityRepository;
    private final PostElmentRepository postElmentRepository;
    /**
     * 테스트용 데이터 추가
     */
   @PostConstruct
    public void init() {
       personalityRepository.save(new Personality("itemA", "A", "smile"));
       personalityRepository.save(new Personality("itemB", "B", "angry"));
       postElmentRepository.save(new PostElement("게시판1","ㅈ같네", "사진1", 1,1));
       postElmentRepository.save(new PostElement("게시판2","ㅈ같네2", "사진2", 2,1));
   }
}
