package org.example;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class EventBus {
    public static final PublishSubject<String> messagesString = PublishSubject.create();
    public static final PublishSubject<Integer> messagesNumber = PublishSubject.create();
}
