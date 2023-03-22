package selfTalk.make.web;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
}