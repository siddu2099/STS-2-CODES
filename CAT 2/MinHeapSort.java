import java.util.*;

public class MinHeapSort {

    static void heapify(int arr[], int n, int i) {
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // find smallest
        if(left < n && arr[left] < arr[smallest])
            smallest = left;

        if(right < n && arr[right] < arr[smallest])
            smallest = right;

        // swap if needed
        if(smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, n, smallest);
        }
    }

    static void heapSort(int arr[], int n) {

        // Build min heap
        for(int i = n/2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements
        for(int i = n-1; i > 0; i--) {

            // Move smallest to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        heapSort(arr, n);

        // Output
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }
}