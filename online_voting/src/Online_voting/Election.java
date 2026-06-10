package Online_voting;

import java.util.List;

public class Election {

    private List<Candidate> candidates;

    public Election(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
    public synchronized void vote(Candidate candidate) {
        candidate.addVote();

    }

}
