package selfTalk.make.web.Home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class Myhome {

    @GetMapping("/TalkRoom/myHome")
    public String makePersonality(){
        log.info("User in /TalkRoom/myHome");
        return "/TalkRoom/myHome";
    }
}
