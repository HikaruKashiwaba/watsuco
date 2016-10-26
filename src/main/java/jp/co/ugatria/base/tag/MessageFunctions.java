package jp.co.ugatria.base.tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.co.ugatria.base.message.Message;

public class MessageFunctions {

    public static List<Message> toOrderedArray(Set<Message> messages, String orderBy) {
        Set<String> set = new HashSet<>();
        List<Message> result = new ArrayList<>();
        if(messages==null) return result;

        for (String propertyName : orderBy.split(",")) {
            for (Message m : messages) {
                if (m.getPropertyName().equals(propertyName) && !set.contains(m.getMessage())) {
                    result.add(m);
                    set.add(m.getMessage());
                }
            }
        }
        return result;
    }

    public static List<Message> pickupFirstHit(Set<Message> messages, String orderBy) {
        List<Message> result = new ArrayList<>();
        if(messages==null) return result;

        for (String propertyName : orderBy.split(",")) {
            for (Message m : messages) {
                if (m.getPropertyName().equals(propertyName)) {
                    result.add(m);
                    return result;
                }
            }
        }
        return result;
    }
}
