package selfTalk.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonalityRepository {
    private static final Map<Long, Personality> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Personality save(Personality personality) {
        personality.setId(++sequence);
        store.put(personality.getId(), personality);
        return personality;
    }

    public static Personality findById(Long id) {
        return store.get(id);
    }

    public static List<Personality> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Personality updateParam) {
        Personality findPersonality = findById(itemId);
        findPersonality.setName(updateParam.getName());
        findPersonality.setEmotions(updateParam.getEmotions());
    }
}
