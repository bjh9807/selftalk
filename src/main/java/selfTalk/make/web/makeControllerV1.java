package selfTalk.make.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import selfTalk.domain.customer.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class makeControllerV1 {
    private final PersonalityRepository personalityRepository;
    private final CustomerRepository customerRepository;
    private final PostElmentRepository postElmentRepository;
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
        return "TalkRoom/makePersonality";
    }

    @PostMapping("/TalkRoom/makePersonality")
    public String makePersonality2(Model model){
        log.info("User make makePersonality");
        return "TalkRoom/myHome";
    }

    @GetMapping("/TalkRoom/talkPersonality")
    public String talkPersonality(Model model){
        log.info("User in talkPersonality");
        List<Personality> personalities = personalityRepository.findAll();
        model.addAttribute("personalities",personalities);
        return "TalkRoom/talkPersonality";
    }

    //회원가입 페이지
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

    @GetMapping("/Post/postLIst")
    public String post(Model model){
        List<PostElement> postElement = PostElmentRepository.findAll();
        model.addAttribute("postElements", postElement);
        log.info("User in post");
        return "Post/postLIst";
    }

    @GetMapping("/Post/postCon/{personalityid}")
    public String post2(Model model , @PathVariable Long personalityid){
        PostElement p = postElmentRepository.findById(personalityid);
        model.addAttribute("PostElement", p);
        log.info("User in postCon");
        return "Post/postCon";
    }

    @GetMapping("/Post/postUpload")
    public String postUploadGet(Model model) {
        model.addAttribute("PostElement", new PostElement());
        log.info("User in upload");
        return "/Post/postUpload";
    }

    @PostMapping("/Post/postUpload")
    public String postUploadPost(@ModelAttribute PostElement postElement, Model model, RedirectAttributes redirectAttributes) {
        // RedirectAttributes redirectAttributes
        log.info("업롤드={}");
        PostElement savePost = PostElmentRepository.save(postElement);
        List<PostElement> postElements = PostElmentRepository.findAll();
        model.addAttribute("postElement", postElements);
//        redirectAttributes.addAttribute("postId", savePost.getPostId());
//        redirectAttributes.addAttribute("status", true);
        return "redirect:/Post/postLIst";

    }


}
