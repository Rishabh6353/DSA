
public class thired {

    public static void spiral (int arr[][],int n, int m){
        int startRow= 0;
        int startCol= 0;
        int endRow = 3;
        int endCol  = 3;

        while(startRow<= endRow && startCol<= endCol){
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(arr[startRow][i]+" ");
            }
            System.out.println();

            for (int j = startRow+1; j <=endRow; j++) {
                System.out.print(arr[j][endCol]+" ");
            }
            System.out.println();

            for (int k = endCol-1; k >= startCol; k--) {
                 if(startCol== endCol){
                    break;
                }
                System.out.print(arr[endRow][k]+" ");
            }
            System.out.println();

            for (int l = endRow-1; l >=startRow+1; l--) {
                if(startRow== endRow){
                    break;
                }
                System.out.print(arr[l][startCol]+" ");
            }
            System.out.println();

             startCol++;
             startRow++;
             endRow--;
             endCol--;
        }
       

    }

    public static int diagonal(int arr[][]){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==j){
                    sum+=arr[i][j];
                }
                else if(i+j== arr.length-1){
                    sum+= arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int optimise(int arr[][]){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i][i];
            //sd
            if (i!= arr.length-1-i) {
                sum+= arr[i][arr.length-1-i];
            }
        }
        return sum;
    }

    public static boolean sorted(int arr[][], int key){
        int row =0;
        int col = arr[0].length-1;

            while(row< arr.length && col>=0){
                if(arr[row][col]== key){
                    System.out.println("Element found at index : "+ row+ " "+ col);
                    return true;
                }
                else if(key< arr[row][col]){
                    col--;
                }else{
                    row++;
                }
        }
        System.out.println("Not found");
        return false;
    }
    public static void main(String[] args) {
        int arr[][]= {{1,2,3,4}, {5,6,7,8},{9,10,11,12}, {13,14,15,16}};
        int m =4, n=4;

        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // spiral(arr, n, m);
        // System.out.println(optimise(arr));

        sorted(arr, 10);
    }
}
