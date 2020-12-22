package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
    private static int[][] dp;
    private static int calculate(int i, int j, String s, String t){
        if(i >= s.length() || j >= t.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = 1 + calculate(i + 1, j + 1, s, t);
            return dp[i][j];
        }else {
            int x = calculate(i + 1, j, s, t);
            int y = calculate(i, j + 1, s, t);
            dp[i][j] = Math.max(x, y);
            return dp[i][j];
        }
    }

    private static String process(int i, int j, String s, String t){
        if(i >= s.length() || j >= t.length()) return "";
        if(s.charAt(i) == t.charAt(j)){
            return s.charAt(i) +""+ process(i + 1, j + 1, s, t);
        }else {
            if(calculate(i + 1, j , s, t) < calculate(i, j + 1, s, t)){
                return process(i, j + 1, s, t);
            }else {
                return process(i + 1, j, s, t);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        String s = br.readLine();
        String t = br.readLine();
        dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        calculate(0, 0, s, t);

        sb.append(process(0, 0, s, t));
        System.out.print(sb.toString());
    }

    private static int nextInt(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }

    private static int[] nextIntArray(BufferedReader br, int n) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    static class Pair<A, B>{
        A first;
        B second;
        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }
}
