package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinaryHeap_Max {

    private int heapSize;
    private int[] heap;

    /** Constructor **/
    public BinaryHeap_Max(int maxSizeArray) {
        heapSize = 0;
        heap = new int[maxSizeArray + 1];
        // Arrays.fill(heap, -1);
    }

    /** Method untuk mengecek apakah Pohon Heap Kosong **/
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /** Method untuk mengecek apakah pohon heap penuh **/
    public boolean isFull() {
        return heapSize == heap.length;
    }

    /** Method untuk mengosongkan Pohon Heap **/
    public void makeEmpty() {
        heapSize = 0;
    }

    /** Method untuk get index parent **/
    private int index_parent(int i) {
        return (i - 1) / 2;
    }

    /** Method untuk get index child **/
    private int index_child(int i, int k) {
        return 2 * i + k;
    }

    /** Method Percolate Up **/
    private void percolateUp_maxHeap(int childInd) {
        int tmp = heap[childInd]; // Menampung elemen child
        while (childInd > 0 && tmp > heap[index_parent(childInd)]) {
            heap[childInd] = heap[index_parent(childInd)]; // Elemen child diisi dengan elemen parent
            childInd = index_parent(childInd); // Indeks child diisi indeks parent
        }
        heap[childInd] = tmp; // Elemen parent diisi tmp
    }

    /** Method untuk insert element **/
    public void insert_maxHeap(int x) {
        if (isFull()) { // Cek apakah pohon penuh
            System.out.println("Full !!!");
            return;
        }
        /** Percolate up **/
        heap[heapSize] = x;
        percolateUp_maxHeap(heapSize++);
    }

    /** Method untuk get largest child **/
    private int maximumChild(int index) {
        int maxChild = index_child(index, 1);
        int k = 2;
        int child_2 = index_child(index, k);
        while ((k <= 2) && (child_2 < heapSize)) {
            if (heap[child_2] > heap[maxChild]) {
                maxChild = child_2;
            }
            k++;
        }
        return maxChild;
    }

    /** Method Percolate Down **/
    private void percolateDown(int index_parent) {
        int child;
        int tmp = heap[index_parent]; // Menampung elemen parent
        while (index_child(index_parent, 1) < heapSize) {
            child = maximumChild(index_parent);
            if (heap[child] > tmp) {
                heap[index_parent] = heap[child];
            } else
                break;
            index_parent = child;
        }
        heap[index_parent] = tmp;
    }

    /** Method untuk delete max element **/
    public int deleteMax() {
        int ind = 0;
        if (isEmpty()) {
            System.out.println("Empty !!!");
            return -1;
        }
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        /** Percolate Down **/
        percolateDown(ind);
        return keyItem;
    }

    /** Method untuk mencetak element heap **/
    public void printHeap() {
        System.out.print("\nMax Binary Heap = ");
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

public class MaxHeap {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------------Max Binary Heap--------------------\n");
        System.out.print("Masukkan Ukuran Array: ");
        int n = Integer.parseInt(br.readLine());

        BinaryHeap_Max maxheap = new BinaryHeap_Max(n);
        maxheap.insert_maxHeap(10);
        maxheap.insert_maxHeap(15);
        maxheap.insert_maxHeap(20);
        maxheap.insert_maxHeap(2);
        maxheap.insert_maxHeap(4);
        maxheap.insert_maxHeap(1);
        maxheap.insert_maxHeap(30);
        maxheap.insert_maxHeap(14);
        maxheap.insert_maxHeap(50);
        maxheap.insert_maxHeap(60);
//        maxheap.insert_maxHeap(42);
        maxheap.printHeap();

        maxheap.deleteMax();
        maxheap.printHeap();
    }
}
