package com.example.incomingcallpro;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ivanc on 08/02/17.
 */

public class NotificationID {
    private final static AtomicInteger c = new AtomicInteger(0);
    public static int getID() {
        return c.incrementAndGet();
    }
}
