package selfTalk.make.web;

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
import selfTalk.make.web.login.LoginForm;

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

    @GetMapping("/")
    public String myhome(Customer loginMember, Model model,@ModelAttribute("loginForm") LoginForm loginform) {
        log.info("User MYHOME");

        if(loginMember==null){
            log.info("User MYHOME2");
            return "Login/Login";
        }

        model.addAttribute("member",loginMember);
        return "Login/Login";
    }
    //@SessionAttribute(name = "loginMember",required = false) Customer loginMember,

//    @GetMapping("/Personality/talkPersonality")
//    public String makePersonality(Model model){
//        model.addAttribute("personality", new Personality());
//        log.info("User in makePersonality");
//        return "Personality/talkPersonality";
//    }
//
//    @PostMapping("/Personality/talkPersonality")
//    public String makePersonality2(Model model){
//        log.info("User make makePersonality");
//        return "TalkRoom/myHome";
//    }

//    @GetMapping("/chat/talkPersonality")
//    public String talkPersonality(Model model){
//        log.info("User in talkPersonality");
//        List<Personality> personalities = personalityRepository.findAll();
//        model.addAttribute("personalities",personalities);
//        return "chat/talkPersonality";
//    }

    //회원가입 페이지
//    @GetMapping("/SignUp/JoinTheMembership")
//    public String signup(Model model){
//        log.info("User in JoinTheMembership");
//        return "SignUp/JoinTheMembership";
//    }
//
//    @GetMapping("/Signup/JoinTheMembership-2")
//    public String signup2(Model model){
//        log.info("User in JoinTheMembership-2");
//        return "Signup/JoinTheMembership-2";
//    }

//    @GetMapping("/Post/postLIst")
//    public String post(Model model){
//        List<PostElement> postElement = PostElmentRepository.findAll();
//        model.addAttribute("postElements", postElement);
//        log.info("User in post");
//        return "Post/postLIst";
//    }
//
//    @GetMapping("/Post/postCon/{personalityid}")
//    public String post2(Model model , @PathVariable Long personalityid){
//        PostElement p = postElmentRepository.findById(personalityid);
//        model.addAttribute("PostElement", p);
//        log.info("User in postCon");
//        return "Post/postCon";
//    }
//
//    @GetMapping("/Post/postUpload")
//    public String postUploadGet(Model model) {
//        model.addAttribute("PostElement", new PostElement());
//        log.info("User in upload");
//        return "/Post/postUpload";
//    }
//
//    @PostMapping("/Post/postUpload")
//    public String postUploadPost(@ModelAttribute PostElement postElement, Model model, RedirectAttributes redirectAttributes) {
//        // RedirectAttributes redirectAttributes
//        log.info("업로드={}");
//        PostElement savePost = PostElmentRepository.save(postElement);
//        List<PostElement> postElements = PostElmentRepository.findAll();
//        model.addAttribute("postElement", postElements);
////        redirectAttributes.addAttribute("postId", savePost.getPostId());
////        redirectAttributes.addAttribute("status", true);
//        return "redirect:/Post/postLIst";
//
//    }


}
