package leetcode.insert_delete;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * Created by user on 2017/6/14.
 */
public class RandomizedSet {

    Map<Integer, Integer> map;
    int size;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
           return false;
        }

        list.add(this.size, val);
        map.put(val, this.size);
        this.size++;

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val) == false) {
            return false;
        }

        if (this.size == 0) {
            map.remove(val);
            return true;
        }
        int tmp = list.get(size - 1);
        map.put(tmp, map.get(val));
        list.set(map.get(val), tmp);
        this.size--;
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(this.size));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.insert(2);
        rs.insert(3);
        rs.remove(1);
        int a = rs.getRandom();
        System.out.println(a);

    }
}

