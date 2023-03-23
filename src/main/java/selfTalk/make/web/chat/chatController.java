package selfTalk.make.web.chat;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import selfTalk.domain.customer.*;
import selfTalk.domain.personality.Personality;
import selfTalk.domain.personality.PersonalityRepository;
import selfTalk.domain.post.PostElement;
import selfTalk.domain.post.PostElmentRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class chatController {
    private final PersonalityRepository personalityRepository;
    private final CustomerRepository customerRepository;
    private final PostElmentRepository postElmentRepository;

    @GetMapping("/chat/talkPersonality")
    public String talkPersonality(Model model){
        log.info("User in talkPersonality");
        List<Personality> personalities = personalityRepository.findAll();
        model.addAttribute("personalities",personalities);
        return "chat/talkPersonality";
    }
}
