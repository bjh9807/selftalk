package selfTalk.domain.customer;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Long id;
    private String password;
    private String name;
    private String email;
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
