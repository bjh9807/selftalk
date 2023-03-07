package selfTalk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import selfTalk.domain.customer.Customer;
import selfTalk.domain.customer.CustomerRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
   private final CustomerRepository itemRepository;

    /**
     * 테스트용 데이터 추가
     */
   @PostConstruct
    public void init() {
        itemRepository.save(new Customer("itemA", "A", "A"));
       itemRepository.save(new Customer("itemB", "B", "B"));
   }
}
