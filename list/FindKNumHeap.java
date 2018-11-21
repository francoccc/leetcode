package leetcode.list;

public class FindKNumHeap {

    class Heap {

        private int[] heap;
        public int size;

        Heap(int size) {
            this.size = 0;
            heap = new int[size];
        }

        public void insert(int ele) {
            heap[size++] = ele;
            update();
        }

        public int get() { return heap[0]; }

        public int delete() {
            int t = heap[0];
            heap[0] = heap[--size];
            shiftDown(0);
            return t;
        }

        private void update() {
            int i = size - 1;
            while(i != 0) {
                int j = (i - 1) / 2;
                if(heap[j] > heap[i]) {
                    int t = heap[i]; heap[i] = heap[j]; heap[j] = t;
                } else break;
                i = j;
            }
        }

        private void shiftDown(int i) {
            while(true) {
                if(2 * i + 2 >= size) break;
                try {
                    int t1 = heap[2 * i + 1];
                    int t2 = heap[2 * i + 2];
                    if(t1 < t2 && heap[i] > t1) {
                        heap[2 * i + 1] = heap[i]; heap[i] = t1;
                        i = 2 * i + 1;
                    }
                    else if(heap[i] > t2){
                        heap[2 * i + 2] = heap[i]; heap[i] = t2;
                        i = 2 * i + 2;
                    }
                    else break;
                } catch (Exception e) {
                    int t = heap[i]; heap[i] = heap[2 * i + 1]; heap[2 * i + 1] = t;
                    i = 2 * i + 1;
                }
            }
        }

        public int getMax() {
            int t = 0;
            for(int i = 0; i < size; i++) {
                if(t < heap[i]) t = heap[i];
            }
            return t;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(k);
        for(int i = 0; i < nums.length; i++) {
            if(heap.size < k) heap.insert(nums[i]);
            else if(nums[i] > heap.get()) {
                heap.delete();
                heap.insert(nums[i]);
            }
        }
        return heap.get();
    }
}
