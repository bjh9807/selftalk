package selfTalk.make.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import selfTalk.domain.customer.Customer;
import selfTalk.domain.customer.CustomerRepository;
import selfTalk.domain.login.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {
    private final LoginService loginService;
    private final CustomerRepository customerRepository;

//    @GetMapping("/Login/Login")
//    public String loginForm(@ModelAttribute("loginForm") LoginForm loginform){
//
//        return "/Login/Login";
//    }

    @GetMapping("/")
    public String myhome(Customer loginMember, Model model, @ModelAttribute("loginForm") LoginForm loginform) {
        log.info("User MYHOME");

        if(loginMember==null){
            log.info("User MYHOME2");
            return "Login/Login";
        }

        model.addAttribute("member",loginMember);
        return "Login/Login";
    }

    @PostMapping("/")
    public String login(@Valid @ModelAttribute LoginForm loginform, HttpServletRequest request, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL){
        if(bindingResult.hasErrors()){
            return "Login/Login";
        }
        Customer loginMember=loginService.login(loginform.getLoginId(),loginform.getPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않는다.");
            return "Login/Login";
        }

        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session=request.getSession(false);
        //세션에 로그인 회원 정보 보관
        session.setAttribute("loginMember",loginMember);
        return "redirect:/TalkRoom/myHome";
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session !=null){
            session.invalidate();
        }
        return "redirect:/";
    }

//    public void expireCookie(HttpServletResponse response,String cookieName){
//        Cookie cookie=new Cookie(cookieName,null);
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
//    }
}
