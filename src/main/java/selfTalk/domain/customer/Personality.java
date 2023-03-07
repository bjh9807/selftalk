package selfTalk.domain.customer;

import lombok.Data;

import java.util.List;

@Data
public class Personality {
    private Long Id;
    private String name;
    private String content;
    private String face;
    private List<String> emotions;

    public Personality() {

    }

    public Personality(String name, String content, String face) {
        this.name=name;
        this.content=content;
        this.face=face;
    }
}
