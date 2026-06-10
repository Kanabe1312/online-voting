package Online_voting;

import java.util.concurrent.locks.ReentrantLock;

public class Statistics {
    private int processed;
    private final ReentrantLock lock = new ReentrantLock();



    public synchronized void incrementProcessed() {
        lock.lock();
        try {
            processed++;
        } finally {
            lock.unlock();
        }
    }

    public synchronized int getProcessed() {
        return processed;
    }

}
