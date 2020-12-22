package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I {
    private static double[][] dp;
    private static double calculate(int current, int heads, double[] p){
        if(heads == 0) return 1;
        if(current < 0) return 0;
        if(dp[current][heads] != -1) return dp[current][heads];
        double p1 = (1 - p[current]) * calculate(current - 1, heads, p);
        double p2 = p[current] * calculate(current - 1, heads - 1, p);
        dp[current][heads] = p1 + p2;
        return p1 + p2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        double[] p = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            p[i] = Double.parseDouble(st.nextToken());
        }
        dp = new double[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        double prob = 0;
        for(int i = n/2+1; i <= n/2+1; i++){
            prob += calculate(n - 1, i, p);
        }
        sb.append(prob);
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
