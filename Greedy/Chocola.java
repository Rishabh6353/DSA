
import java.util.*;

public class Chocola {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] < costHor[h]) {

                cost += costHor[h] * vp;
                h++;
                hp++;
            } else {

                cost += costVer[v] * hp;
                v++;
                vp++;
            }
        }

        // for remaining
        while (h < costHor.length) {

            cost += costHor[h] * vp;
            h++;
            hp++;
        }

        while (v < costVer.length) {

            cost += costVer[v] * hp;
            v++;
            vp++;
        }

        System.out.println("Minimum cost of cuts = " + cost);
    }
}
