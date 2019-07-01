package com.company;

public static class MailMessage extends SendableClass<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
