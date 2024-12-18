package heap;

class MinHeap{
	private int heapSize;
	private int[] heap;
	public MinHeap(int maxSizeArray) {
		heapSize = 0;
		heap = new int[maxSizeArray];
	}
	
	public boolean isEmpty() {
		return heapSize ==0;
	}
	public boolean isFull () {
		return heapSize == heap.length;
	}
	private int index_paren(int i) {
		return (i-1)/2;
	}
	private int index_child (int i, int k) {
		return 2 * i + k;
	}
	private void percolateUp(int child_ind) {
		int temp = heap[child_ind];
		while(child_ind > 0 && temp < heap[index_paren(child_ind)]) {
			heap[child_ind] = heap[index_paren(child_ind)];
			child_ind = index_paren(child_ind);
		}
		heap[child_ind] = temp;
	}
	public void insert(int x) {
		if (isFull()) {
			System.out.println("Heap Full!!!");
		}
		heap[heapSize] = x;
		percolateUp(heapSize++);
	}
	private int minChild(int index) {
		int minChild = index_child(index, 1);
		int k = 2;
		int child_2 = index_child(index, k);
		while(k <= 2 && child_2 < heapSize) {
			if (heap[child_2] < heap[minChild(index)]) {
				minChild = child_2;
			}
			k++;
		}
		return minChild;
	}
	private void percolateDown (int index_parent) {
		int child;
		int temp = heap[index_parent];
		while(index_child(index_parent, 1) < 1) {
			child = minChild(index_parent);
			if (heap[child] < temp) {
				heap[index_parent] = heap[child];
			}
			else {
				break;
			}
			index_parent = child;
		}
		heap[index_parent] = temp;
	}
	public int deleteMin() {
		int ind = 0;
		if (isEmpty()) {
			System.out.println("Heap Kosong!!!");
		}
		int keyItem = heap[ind];
		heap [ind] = heap[heapSize-1]; // digantikan root dgn element terakhir
		heapSize--;
		percolateDown(ind);
		return keyItem;
	}
	public void tampilHeap() {
		System.out.println(" --- MIN Heap ---");
		for(int i = 0; i< heapSize; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}

public class Binary_Heap {

	
	public static void main(String[] args) {
		MinHeap heap = new MinHeap(100);
		heap.insert(13);
		heap.insert(0);
		heap.insert(4);
		heap.insert(-1);
		heap.insert(15);
		heap.insert(-2);
		heap.tampilHeap();
	}

}
