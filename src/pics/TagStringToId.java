package pics;

import java.util.HashMap;
import java.util.Map;

public class TagStringToId {

    Map<String, Integer> tagToStringMap;
    Integer id;


    public TagStringToId() {
        id = 0;
        tagToStringMap = new HashMap<>();
    }

    public Integer getIdOfTag(String tag) {
        if(!tagToStringMap.containsKey(tag)) {
            tagToStringMap.put(tag, id);
            id = id + 1;
        }
        return tagToStringMap.get(tag);
    }

}
