package heap;
public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size >= heap.length) {
            // Resize the array or handle overflow
            return;
        }

        heap[size] = value;
        int index = size;

        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }

        size++;
    }

    public int extractMax() {
        if (size == 0) {
            // Handle underflow
            return Integer.MIN_VALUE;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return max;
    }

    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(2);

        while (maxHeap.size > 0) {
            System.out.println(maxHeap.extractMax()); // Output: 8, 5, 3, 2
        }
    }
}
