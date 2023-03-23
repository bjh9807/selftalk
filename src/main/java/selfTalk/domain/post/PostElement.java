package selfTalk.domain.post;

import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostElement {
//    private Personality personality1=new Personality("itemA", "A", "ddddd");
//    private Personality personality2=new Personality("itemB", "B", "angry");
    private Long postId;
    private String name;
    private String content;
    private String picture;
    private String comment;


//    private long p1=getPersonality1().getId();
//    private long p2=getPersonality2().getId();
    private int customerId;
    private int personalityId;


    public PostElement(String name, String content, String picture){
        this.name=name;
        this.content=content;
        this.picture=picture;

    }
}
