

public class second {

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selection(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = j;
                }
                swap(arr, i, j);
            }
        }
    }

    public static void insertion(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
                arr[prev + 1] = curr;
            }
        }
    }

    public static void count(int arr[]) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index=0;
        for (int i = 0; i < count.length; i++) {
                while (count[i] > 0) {
                    arr[index++] = i;
                    count[i]--;
                }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,4,1,3,2,4,3,7};
        // selection(arr);
        // insertion(arr);
        // Arrays.sort(arr,Collections.reverseOrder());
        count(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
