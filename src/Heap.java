public class Heap {
    private int[] data;
    private int size;
    public Heap() {
        this.size = 0;
        this.data = new int[100];

    }
    public int getParentIndex(int index) {
        return (index - 1) / 2;

    }
    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
    public void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
       data[index2] = temp;
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);

            if(data[index] < data[parentIndex]){                swap(index, parentIndex);
                swap(index, parentIndex);
                index = parentIndex;
            }
        }
    }
    public void add(int item){
        data[size]=item;
        heapifyUp(size);
        size++;
    }//end add
    public void show(){
        for(int i = 0; i < size; i++){
            System.out.println( i + ": "+data[i]);
        }
    }
    public void heapifyDown(int index) {

        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallest = index;
        do {
            //if leftchildIndex exists and data[leftchildIndex] is smaller than
            // data[smallest] then update smallest to leftchildIndex
            if (leftChildIndex < size && data[leftChildIndex] < data[smallest]) {
                smallest = leftChildIndex;
            }

            if (rightChildIndex < size && data[rightChildIndex] < data[smallest]) {
                smallest = rightChildIndex;
            }

            // if smallest is changed swap current node with smaller child
            //update index = smallest whill continue checking downward
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;//this keeps it moving down
            }
        }while (smallest != index); //stopping when no swap is needed
    }
    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
        }
        int min = data[0]; //Root is smallest in min-heap
        data[0] = data[size - 1];//last element to root
        size--;
        heapifyDown(0);//make heap again
        return min;//return removed value
    }

}
