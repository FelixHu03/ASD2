package heap;

public class Test_FixHeap {

    public void buildHeap(int arr[]) {
        int n = arr.length;
        // Build heap (mengatur binary heap)
        for (int i = n; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    void heapify(int arr[], int n, int i) { // n = heapSize
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {4, 10, 3, 5, 1};
        int n = arr.length;

        Test_FixHeap ob = new Test_FixHeap();
        ob.buildHeap(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
