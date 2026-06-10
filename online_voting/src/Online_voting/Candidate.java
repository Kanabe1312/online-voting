package Online_voting;

import java.util.concurrent.locks.ReentrantLock;

public class Candidate {

    private String name;
    private int votes;
    private final ReentrantLock lock = new ReentrantLock();


    public Candidate(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public int getVotes() {
        return votes;
    }

    public void addVote(){
        lock.lock();
        try {
            votes ++;
        } finally {
            lock.unlock();
        }
    }


}
