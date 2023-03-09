package selfTalk.make.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class makControllerV2 {
//    @GetMapping("/Post/postLIst")
//    public String post(Model model){
//        log.info("User in post");
//        return "/Post/postLIst";
//    }
}
