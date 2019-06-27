package com.company;

public interface Sendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}
