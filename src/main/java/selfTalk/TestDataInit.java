package selfTalk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import selfTalk.domain.customer.*;
import selfTalk.domain.personality.Personality;
import selfTalk.domain.personality.PersonalityRepository;
import selfTalk.domain.post.PostElement;
import selfTalk.domain.post.PostElmentRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
   private final CustomerRepository customerRepository;
    private final PersonalityRepository personalityRepository;
    private final PostElmentRepository postElmentRepository;
    /**
     * 테스트용 데이터 추가
     */
   @PostConstruct
    public void init() {
       personalityRepository.save(new Personality("분노", "인생을 한심하게 보는 내 안의 열등감", "angry"));
       personalityRepository.save(new Personality("웃음", "인생을 살아가게 하는 원동력", "smile"));
       postElmentRepository.save(new PostElement("게시판1","ㅈ같네", "사진1"));
       postElmentRepository.save(new PostElement("게시판2","ㅈ같네2", "사진2"));

       Customer C=new Customer();
       C.setEmail("test");
       C.setPassword("test!");
       C.setName("dddd");
       customerRepository.save(C);
   }
}
