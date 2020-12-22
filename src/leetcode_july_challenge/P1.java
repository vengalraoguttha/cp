package leetcode_july_challenge;

public class P1 {
    public int arrangeCoins(int n) {
        if(n == 0) return 0;
        long start = 1;
        long end = n;
        int ans = 0;
        while (start <= end){
            long mid = start + (end - start)/2;
            long val = mid * (mid + 1)/2;
            if(val <= n){
                ans = (int) mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
