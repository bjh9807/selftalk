package selfTalk.make.web.Signup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import selfTalk.domain.customer.CustomerRepository;
import selfTalk.domain.personality.PersonalityRepository;
import selfTalk.domain.post.PostElmentRepository;


@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SignupController {
    private final PersonalityRepository personalityRepository;
    private final CustomerRepository customerRepository;
    private final PostElmentRepository postElmentRepository;

    @GetMapping("/SignUp/JoinTheMembership")
    public String signup(Model model){
        log.info("User in JoinTheMembership");
        return "SignUp/JoinTheMembership";
    }

    @GetMapping("/Signup/JoinTheMembership-2")
    public String signup2(Model model){
        log.info("User in JoinTheMembership-2");
        return "Signup/JoinTheMembership-2";
    }

}
