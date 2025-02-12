public class Heap {
    private int[] heap;
    private int size;
    public Heap(int size) {
        this.heap = new int[size];
        this.size = size;
    }
    public int getParent(int index) {
        return (index - 1) / 2;

    }
    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
    public void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    public void heapifyUp(int index) {
        int parent = getParent(index);
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
       while (index <parent){
           swap(index, parent);
           heap[index]=heap[parent];

        }
    }
    public void add(int item){

    }
}
