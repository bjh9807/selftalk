package selfTalk.make.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import selfTalk.domain.customer.Customer;
import selfTalk.domain.customer.Personality;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class makeControllerV1 {

    @ModelAttribute("emotions")
    public Map<String, String> emotions() {
        Map<String, String> emotions = new LinkedHashMap<>();
        emotions.put("ANGER", "분노");
        emotions.put("SAD", "슬픔");
        emotions.put("HAPPY", "기쁨");
        emotions.put("JOY", "즐거움");
        emotions.put("LOVE", "사랑");
        emotions.put("HATRED", "증오");
        emotions.put("SHAME", "창피");
        emotions.put("CRAVING", "욕망");
        emotions.put("ANXIETY", "불안");
        emotions.put("WORRY", "걱정");
        emotions.put("MOVED", "감동");
        emotions.put("CURIOSITY", "호기심");
        emotions.put("CONFIDENCE", "자신감");
        return emotions;
    }

    @GetMapping("/TalkRoom/myHome")
    public String myhome(Model model) {
        log.info("User in myhome");
        return "TalkRoom/myHome";
    }

    @GetMapping("/TalkRoom/makePersonality")
    public String makePersonality(Model model){
        model.addAttribute("personality", new Personality());
        log.info("User in makePersonality");
        return "/TalkRoom/makePersonality";
    }

    @PostMapping("/TalkRoom/makePersonality")
    public String makePersonality2(Model model){
        log.info("User make makePersonality");
        return "TalkRoom/myHome";
    }

    @GetMapping("/TalkRoom/post")
    public String post(Model model){
        log.info("User in post");
        return "/TalkRoom/post";
    }

    @GetMapping("/TalkRoom/talkPersonality")
    public String talkPersonality(Model model){
        log.info("User in talkPersonality");
        return "/TalkRoom/talkPersonality";
    }

    //회원가입 페이지
    @GetMapping("/SignUp/JoinTheMembership")
    public String signup(Model model){
        log.info("User in JoinTheMembership");
        return "/SignUp/JoinTheMembership";
    }

    @GetMapping("/Signup/JoinTheMembership-2")
    public String signup2(Model model){
        log.info("User in JoinTheMembership-2");
        return "/Signup/JoinTheMembership-2";
    }
}
