package Online_voting;

public class Candidate {

    private String name;
    private int votes;

    public Candidate(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }
    public String getName() {
        return name;
    }
    public int getVotes() {
        return votes;
    }

    public synchronized void addVotes(int votes) {
    votes++;
    }


}
