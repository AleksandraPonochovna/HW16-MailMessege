package com.company;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {

    private Map<String, List<T>> mailBox;

    private Map<String, List<T>> messagesMap = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            if (this.containsKey(key)) {
                return super.get(key);
            } else {
                return Collections.emptyList();
            }
        }
    };

    @Override
    public void accept(Sendable<T> sendable) {
        List<T> ts = messagesMap.get(sendable.getTo());
        if (ts.size() == 0) {
            ts = new ArrayList<>();
        }
        ts.add(sendable.getContent());
        messagesMap.put(sendable.getTo(), ts);
    }

    public Map<String, List<T>> getMailBox() {
        return messagesMap;
    }
}
