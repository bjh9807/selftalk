package selfTalk.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.*;

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

    public Optional<Customer> findByLoginId(String loginId){
        List<Customer> all= findAll();
        for(Customer m:all){
            if(m.getEmail().equals(loginId)){
                return Optional.of(m);
            }
        }
        return Optional.empty();
        //    return findAll().stream().
        //            filter(m->m.getLoginId().equals(loginId)).findFirst();
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
