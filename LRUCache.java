package leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, Integer> deck;
    private Map<Integer, Integer> life;
    private int capacity;
    private int size;
    private int[] nums;
    private int p = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deck = new HashMap<>(capacity);
        life = new HashMap<>(capacity);
        nums = new int[capacity];
        size = 0;
    }

    public int get(int key) {
        Integer r = deck.get(key);
        if(null == r) return -1;
        else {
            life.put(key, life.get(key) + 1);
            return r;
        }
    }

    public void put(int key, int value) {
        if(size == capacity) {
            while(true) {
                if(life.get(nums[p]) == 0) {
                    deck.remove(nums[p]);
                    life.remove(nums[p]);
                    deck.put(key, value);
                    life.put(key, 0);
                    nums[p] = key;
                    p = (p + 1) % capacity;
                    break;
                }
                else {
                    life.put(nums[p], life.get(nums[p]) - 1);
                    p = (p + 1) % capacity;
                }
            }
        } else {
            deck.put(key, value);
            life.put(key, 0);
            nums[size++] = key;
        }
    }
}
