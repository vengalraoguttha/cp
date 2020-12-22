package leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

public class RegularExpressionMatching {
    private static int[][] dp;
    private boolean calculate(int i, int j, String s, String p){
        if(i == s.length() && j == p.length()) return true;
        if(i == s.length()) {
            if(dp[i][j] == 0) return false;
            if(dp[i][j] == 1) return true;
            boolean res = true;
            for(int l = j; l < p.length(); l++){
                if((p.charAt(l) != '*' && l + 1 < p.length() && p.charAt(l + 1) != '*')
                    || (p.charAt(l) != '*' && l + 1 >= p.length())){
                    res = false;
                }
            }
            if(res) dp[i][j] = 1;
            else dp[i][j] = 0;
            return res;
        }
        if(j == p.length()) return false;
        if(dp[i][j] == 0) return false;
        if(dp[i][j] == 1) return true;

        if(j + 1 < p.length()){
            if(p.charAt(j) == '.' && p.charAt(j + 1) == '*'){
                boolean res = false;
                for(int l = i; l <= s.length(); l++){
                    res = res || calculate(l, j + 2, s, p);
                }
                if(res) dp[i][j] = 1;
                else dp[i][j] = 0;
                return res;
            } else if(p.charAt(j + 1) == '*'){
                char ch = p.charAt(j);
                boolean res = calculate(i, j + 2, s, p);
                for(int l = i; l < s.length(); l++){
                    if(ch != s.charAt(l)) break;
                    res = res || calculate(l + 1, j + 2, s, p);
                }
                if(res) dp[i][j] = 1;
                else dp[i][j] = 0;
                return res;
            } else if(p.charAt(j) == '.'){
                boolean res = calculate(i + 1, j + 1, s, p);
                if(res) dp[i][j] = 1;
                else dp[i][j] = 0;
                return res;
            } else {
                if(s.charAt(i) != p.charAt(j)){
                    dp[i][j] = 0;
                    return false;
                }
                boolean res = calculate(i + 1, j + 1, s, p);
                if(res) dp[i][j] = 1;
                else dp[i][j] = 0;
                return res;
            }
        } else {
            if(p.charAt(j) == '.'){
                boolean res = calculate(i + 1, j + 1, s, p);
                if(res) dp[i][j] = 1;
                else dp[i][j] = 0;
                return res;
            } else {
                if(s.charAt(i) != p.charAt(j)){
                    dp[i][j] = 0;
                    return false;
                }
                boolean res = calculate(i + 1, j + 1, s, p);
                if(res) dp[i][j] = 1;
                else dp[i][j] = 0;
                return res;
            }
        }
    }

    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        for(int i = 0; i < s.length() + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        return calculate(0, 0, s, p);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch(sc.next(), sc.next()));
    }
}
