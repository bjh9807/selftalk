package selfTalk.domain.customer;

public class Customer {

    String id;
    String password;
    String name;
    String email;
    String created_date;

    public Customer(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
