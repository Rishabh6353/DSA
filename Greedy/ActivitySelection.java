import java.util.ArrayList;

public class ActivitySelection{
    public static void main(String[] args) {
        int start[ ] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};


        //if end time was not sorted
        int activites[] [] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activites[i][0] = i;
            activites [i] [1] = start[i];
            activites[i][2] = end[i];
        }



        //end time basis sorted
        int maxAct = 0;
        //to add indices of the activites selected
        ArrayList<Integer> al = new ArrayList<>();

        maxAct = 1;
        //adding first activity index
        al.add(0);
        int lastend = end[0];

        for (int i = 1; i < end.length; i++) {
            if(start[i]>= lastend){
                al.add(i);
                maxAct++;
                lastend = end[i];
            }
        }
        System.out.println(maxAct);

        for (int i = 0; i < al.size(); i++) {
            System.out.print("A"+al.get(i)+" ");
        }
    }
}