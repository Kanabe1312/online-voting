package Online_voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        List<Candidate> candidates = new ArrayList<>();

        candidates.add(new Candidate("Maria"));

        candidates.add(new Candidate("Alex"));

        candidates.add(new Candidate("Cristian"));


        Election election = new Election(candidates);
        Statistics statistics = new Statistics();

        Thread dashboard = new Thread(new DashboardTask(election, statistics));
        dashboard.setDaemon(true);
        dashboard.start();

        ExecutorService executor = Executors.newFixedThreadPool(8);

        Random  random = new Random();
        for(int i = 0; i < 1000; i++){
            Candidate candidate = candidates.get(random.nextInt(3));
            executor.submit(new VoteTask(candidate,election,statistics));
        }

        while(statistics.getProcessed() < 1000){
            Thread.sleep(50);
        }

        executor.shutdown();


        int totalVotes = 0;

        for(Candidate candidate : candidates){
            totalVotes += candidate.getVotes();
        }
        System.out.println("Total votes: " + totalVotes);


        Candidate winner = candidates.get(0);
        for(Candidate candidate : candidates){
            if(candidate.getVotes() > winner.getVotes()){
                winner = candidate;
            }
        }
        long endTime = System.currentTimeMillis();


        System.out.println();
        System.out.println("===Raport Fianl===");

        for(Candidate candidate : candidates){
            System.out.println(candidate.getName() + ": " + candidate.getVotes());
        }
        System.out.println();
        System.out.println("Winner: "+winner.getName());

        System.out.println("Duration: " + (endTime - startTime));






    }

}
