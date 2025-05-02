package org.example;

@FunctionalInterface
public interface Validator {
    boolean validate(int value);
}
