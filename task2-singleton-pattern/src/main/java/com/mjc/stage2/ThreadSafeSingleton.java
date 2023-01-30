package com.mjc.stage2;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton safeSingleton;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (safeSingleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                safeSingleton = new ThreadSafeSingleton();
            }
        }
        return safeSingleton;
    }

    // Write your code here!
}
