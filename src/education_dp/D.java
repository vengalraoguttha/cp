package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    private static long[][] dp;
    private static long calculate(int current, int w, int[][] arr){
        if(w == 0) return 0;
        if(w < 0) return Integer.MIN_VALUE;
        if(current >= arr.length) return 0;
        if(dp[current][w] != -1) return dp[current][w];
        long x = calculate(current + 1, w, arr);
        long y = calculate(current + 1, w - arr[current][0], arr);
        if(y != Integer.MIN_VALUE) y += arr[current][1];
        dp[current][w] = Math.max(x, y);
        return Math.max(x, y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int n = in[0];
        int w = in[1];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i] = nextIntArray(br, 2);
        }
        dp = new long[n][w + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        sb.append(calculate(0, w, arr));
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
