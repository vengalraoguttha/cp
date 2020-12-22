package leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DecodeWays {
    private int[] dp;
    private int calculate(String s, int pos){
        if(pos >= s.length()) return 1;
        if(dp[pos] != -1) return dp[pos];
        int current = s.charAt(pos) - '0';
        if(current > 2){
            dp[pos] = calculate(s, pos + 1);
            return dp[pos];
        }
        if(current == 2){
            if(pos == s.length() - 1){
                dp[pos] = 1;
                return 1;
            } else {
                int next = s.charAt(pos + 1) - '0';
                if(next <= 6 && next >= 1){
                    dp[pos] = calculate(s, pos + 1) + calculate(s, pos + 2);
                    return dp[pos];
                } else {
                    if(next == 0){
                        dp[pos] = calculate(s, pos + 2);
                    } else {
                        dp[pos] = calculate(s, pos + 1);
                    }
                    return dp[pos];
                }
            }
        } else if(current == 1){
            if(pos == s.length() - 1){
                dp[pos] = 1;
                return 1;
            }
            int next = s.charAt(pos + 1) - '0';
            if(next == 0){
                dp[pos] = calculate(s, pos + 2);
                return dp[pos];
            }
            dp[pos] = calculate(s, pos + 1) + calculate(s, pos + 2);
            return dp[pos];
        } else {
            return 0;
        }
    }

    public int numDecodings(String s) {
        dp = new int[s.length() + 10];
        Arrays.fill(dp, -1);
        if(s.charAt(0) == '0') return 0;
        return calculate(s, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings(sc.next()));
    }
}
