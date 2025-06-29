import java.util.*;

public class ActivitySelection2{
    public static void main(String[] args) {
        int start[ ] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};


        //if end time was not sorted
        int activities[] [] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities [i] [1] = start[i];
            activities[i][2] = end[i];
        }

        //sorting using lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        //to add indices of the activites selected
        ArrayList<Integer> al = new ArrayList<>();

        maxAct = 1;
        //adding first activity index
        al.add(activities[0][0]);
        int lastend = activities[0] [2];

        for (int i = 1; i < end.length; i++) {
            if(activities[i][1]>= lastend){
                al.add(activities[i][0]);
                maxAct++;
                lastend = activities[i][2];
            }
        }
        System.out.println(maxAct);

        for (int i = 0; i < al.size(); i++) {
            System.out.print("A"+al.get(i)+" ");
        }
    }
}