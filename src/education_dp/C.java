package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    private static long[][] dp;
    private static long calculate(int current, int previous, int[][] arr){
        if(current >= arr.length) return 0;
        if(previous == -1){
            long ans = Long.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                long x = calculate(current + 1, i, arr);
                if(x != Long.MIN_VALUE) x+=arr[current][i];
                ans = Math.max(ans, x);
            }
            return ans;
        }
        if(dp[current][previous] != -1) return dp[current][previous];
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            if(previous == i) continue;
            long x = calculate(current + 1, i, arr);
            if(x != Long.MIN_VALUE) x+=arr[current][i];
            ans = Math.max(ans, x);
        }
        dp[current][previous] = ans;
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            arr[i] = nextIntArray(br, 3);
        }
        dp = new long[n][3];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        sb.append(calculate(0, -1, arr));
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
