package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<T> list = messagesMap.get(sendable.getTo());
        if (list.isEmpty()) {
            list = new ArrayList<>();
        }
        list.add(sendable.getContent());
        messagesMap.put(sendable.getTo(), list);
    }

    public Map<String, List<T>> getMailBox() {
        return messagesMap;
    }
}
