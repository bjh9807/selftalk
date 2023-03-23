package selfTalk.domain.post;

import org.springframework.stereotype.Repository;
import selfTalk.domain.post.PostElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostElmentRepository {
    private static final Map<Long, PostElement> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public static PostElement save(PostElement postElement) {
        postElement.setPostId(++sequence);
        store.put(postElement.getPostId(), postElement);
        return postElement;
    }

    public static PostElement findById(Long id) {
        return store.get(id);
    }

    public static List<PostElement> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long postId, PostElement updateParam) {
        PostElement findPost = findById(postId);
        findPost.setName(updateParam.getName());
        findPost.setContent(updateParam.getContent());
        findPost.setPicture(updateParam.getPicture());
    }
}
