package leetcode_july_challenge;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0 || n == 0) return tasks.length;
        int[] counts = new int[26];
        for(int i = 0; i < tasks.length; i++){
            counts[tasks[i] - 'A']++;
        }
        Arrays.sort(counts);
        int max = counts[25];
        int num = 0;
        for(int i = 0; i < 26; i++){
            if(max == counts[i]){
                num++;
            }
        }
        return Math.max((max - 1)*(n + 1) + num, tasks.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = sc.next().charAt(0);
        }
        TaskScheduler t = new TaskScheduler();
        System.out.println(t.leastInterval(chars, k));
    }
}
