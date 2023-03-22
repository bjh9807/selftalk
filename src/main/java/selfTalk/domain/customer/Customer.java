package selfTalk.domain.customer;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Long id; //고유 번호
    private String password; //패스워드
    private String email; // 아이디
    private String name; //이름

    private String created_date;
    private List<String> emotions;

    public Customer() {
    }
    public Customer(String password, String name,String email) {

        this.password = password;
        this.name=name;
        this.email=email;
    }
}
