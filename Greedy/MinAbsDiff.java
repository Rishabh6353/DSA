import java.util.*;
public class MinAbsDiff{
    //Q- Given 2 arrays of equal length n . Pair each element of Array 1 to element in Array 2 such that sum S of absolute diff of all pairs is minimum
    public static void main(String[] args) {
        int arr1 [ ] = {4,1,8,7};
        int arr2 [ ]= {2,3,6,5};

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int minDiff = 0;

        for (int i = 0; i < arr2.length; i++) {
            minDiff += Math.abs(arr1[i]- arr2[i]);
        }

        System.out.println(minDiff);
    }
}