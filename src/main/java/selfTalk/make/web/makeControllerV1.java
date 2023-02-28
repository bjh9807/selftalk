package selfTalk.make.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class makeControllerV1 {

    @GetMapping("/TalkRoom/myhome")
    public String myhome(Model model) {
        log.info("User in joinForm");
        return "TalkRoom/myhome";
    }
}
