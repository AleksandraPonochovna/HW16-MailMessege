package com.company;

import java.util.*;
import java.util.function.Consumer;

public static class MailService<T> implements Consumer<Sendable<T>> {

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
        List<T> list = messagesMap.get(sendable.getTo());
        if (list.size() == 0) {
            list = new ArrayList<>();
        }
        list.add(sendable.getContent());
        messagesMap.put(sendable.getTo(), list);
    }

    public Map<String, List<T>> getMailBox() {
        return messagesMap;
    }
}
