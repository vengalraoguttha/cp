package leetcode_august_challenge;

public class DesignHashSet {
    class MyHashSet {
        int MAX = 1000000 + 5;
        int[] map;
        /** Initialize your data structure here. */
        public MyHashSet() {
            map = new int[MAX];
        }

        public void add(int key) {
            if(map[key] == 0) map[key]++;
        }

        public void remove(int key) {
            if(map[key] > 0) map[key]--;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return map[key] > 0;
        }
    }
}
