package leetcode.wc_212;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        long[] arr = new long[26];
        arr[keysPressed.charAt(0) - 'a'] += releaseTimes[0];
        for(int i = 1; i < releaseTimes.length; i++){
            arr[keysPressed.charAt(i) - 'a'] += releaseTimes[i] - releaseTimes[i - 1];
        }
        long max = 0;
        char ch = '1';
        for(int i = 0; i < 26; i++){
            if(arr[i] >= max){
                max = arr[i];
                ch = (char) ('a' + i);
            }
        }
        return ch;
    }
}
