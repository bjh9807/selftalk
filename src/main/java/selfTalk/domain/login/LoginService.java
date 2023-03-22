package selfTalk.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import selfTalk.domain.customer.Customer;
import selfTalk.domain.customer.CustomerRepository;
@Service
@RequiredArgsConstructor
public class LoginService {
    private final CustomerRepository customerRepository;

    public Customer login(String loginId, String password){
        //    Optional<Member> findMemberOptional=memberRepository.findByLoginId(loginId);
        //    Member member=findMemberOptional.get();
        //    if(member.getPassword().equals(password)){
        //        return member;
        //     }else {
        //        return null;
        //    }
        return customerRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
