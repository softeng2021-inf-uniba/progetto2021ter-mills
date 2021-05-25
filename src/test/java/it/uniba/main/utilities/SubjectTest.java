package it.uniba.main.utilities;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {
  @Test
  public void testSubject() {
    AtomicBoolean value = new AtomicBoolean(false);

    StringBuilder str = new StringBuilder();
    Subject<Boolean> subject = new Subject<>();
    Observer<Boolean> observer = arg -> value.set(arg);

    assertFalse(value.get());

    subject.register(observer);
    subject.notifyObservers(true);
    assertTrue(value.get());

    value.set(false);
    subject.unregister(observer);
    subject.notifyObservers(true);
    assertFalse(value.get());
  }
}
