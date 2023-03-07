package selfTalk.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {
    private static final Map<Long, Customer> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Customer save(Customer customer) {
        customer.setId(++sequence);
        store.put(customer.getId(), customer);
        return customer;
    }

    public Customer findById(Long id) {
        return store.get(id);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Customer updateParam) {
        Customer findItem = findById(itemId);
        findItem.setName(updateParam.getName());
        findItem.setEmotions(updateParam.getEmotions());
    }
}
