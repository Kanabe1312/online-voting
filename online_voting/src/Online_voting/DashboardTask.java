package Online_voting;

public class DashboardTask implements Runnable {

    private Election election;
    private Statistics statistics;

    public DashboardTask(Election election, Statistics statistics) {
        this.election = election;
        this.statistics = statistics;
    }

    @Override
    public void run() {
    while(statistics.getProcessed() < 1000){
        System.out.println();
        System.out.println("[dashboard]");

        for(Candidate candidate : election.getCandidates()){
            System.out.println(candidate.getName()+": "+ statistics.getProcessed());
        }
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }


    }


}
