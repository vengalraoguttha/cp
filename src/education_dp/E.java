package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
    private static long[][] dp;
    private static long calculate(int current, int value, int[][] arr){
        if(current < 0 && value == 0) return 0;
        if(current < 0) return Long.MAX_VALUE;
        if(value < 0) return Long.MAX_VALUE;
        if(dp[current][value] != -1) return dp[current][value];
        long x = calculate(current - 1, value, arr);
        long y = calculate(current - 1, value - arr[current][1], arr);
        if(y != Long.MAX_VALUE){
            y += arr[current][0];
        }
        dp[current][value] = Math.min(x, y);
        return Math.min(x, y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int n = in[0];
        int w = in[1];
        int[][] arr = new int[n][2];
        int maxValue = 0;
        for(int i = 0; i < n; i++){
            arr[i] = nextIntArray(br, 2);
            maxValue += arr[i][1];
        }
        dp = new long[n][maxValue + 1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < maxValue + 1; i++)
            calculate(n - 1, i, arr);
        int ans = 0;
        for(int i = 0; i <= maxValue; i++){
            if(dp[n - 1][i] <= w && dp[n - 1][i] > 0) ans = i;
        }
        sb.append(ans);
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
