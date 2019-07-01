package com.company;

public static interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}
