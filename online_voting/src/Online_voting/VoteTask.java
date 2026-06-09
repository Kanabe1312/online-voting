package Online_voting;

import java.util.Random;

public class VoteTask  implements Runnable {

    private Candidate candidate;
    private Election election;
    private Statistics statistics;
    public VoteTask(Candidate candidate, Election election, Statistics statistics) {
        this.candidate = candidate;
        this.election = election;
        this.statistics = statistics;
    }
    @Override
    public void run() {
        Random  random = new Random();
        try {
            Thread.sleep(random.nextInt(11)+5);
        } catch (InterruptedException e) {
           return;
        }
    }
}
