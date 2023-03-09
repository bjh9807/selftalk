package selfTalk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import selfTalk.domain.customer.Customer;
import selfTalk.domain.customer.CustomerRepository;
import selfTalk.domain.customer.Personality;
import selfTalk.domain.customer.PersonalityRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
   private final CustomerRepository itemRepository;
    private final PersonalityRepository personalityRepository;

    /**
     * 테스트용 데이터 추가
     */
   @PostConstruct
    public void init() {
       personalityRepository.save(new Personality("itemA", "A", "A"));
       personalityRepository.save(new Personality("itemB", "B", "B"));
   }
}
