
import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        ArrayList<Job> al= new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            al.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(al, (obj1,obj2) -> obj2.profit- obj1.profit);  //desceding order of comparing obj

        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();

        for (int i = 0; i < al.size(); i++) {
            Job curr = al.get(i);

            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }
        
    }
}
