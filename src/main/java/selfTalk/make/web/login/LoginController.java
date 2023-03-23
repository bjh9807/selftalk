package selfTalk.make.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/")
    public String login(@ModelAttribute LoginForm loginform, HttpServletRequest request){
//        if(bindingResult.hasErrors()){
//            return "/Login/Login";
//        }
        Customer loginMember=loginService.login(loginform.getLoginId(),loginform.getPassword());

//        if(loginMember==null){
//            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않는다.");
//            return "/Login/Login";
//        }

        HttpSession session=request.getSession();
        session.setAttribute("loginMember",loginMember);
        return "redirect:/TalkRoom/myHome";
    }

    @PostMapping("logout")
    public String logout(HttpServletResponse response){
        expireCookie(response,"memberId");
        return "redirect:/";
    }

    public void expireCookie(HttpServletResponse response,String cookieName){
        Cookie cookie=new Cookie(cookieName,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
