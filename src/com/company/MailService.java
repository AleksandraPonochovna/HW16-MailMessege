package com.company;

import java.util.*;
import java.util.function.Consumer;

public static class MailService<T> implements Consumer<Sendable<T>> {

    private Map<String, List<T>> messagesMap;

    public MailService() {
        messagesMap = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return getOrDefault(key, Collections.emptyList());
            }
        };
    }

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
