package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FICE {
    static int[] dp;
    private static int calculate(int n, int m){
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        int res = 0;
        for(int i = 1; i <= n; i+=2){
            res += 2*calculate2(n - i, m) % m;
        }
        dp[n] = res;
        return res;
    }
    private static int calculate2(int n, int m){
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        int res = 0;
        for(int i = 1; i <= n; i+=2){
            res += calculate2(n - i, m) % m;
        }
        dp[n] = res;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] in = nextIntArray(br, 2);
            int n = in[0];
            int m = in[1];
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            sb.append(calculate(n, m)).append("\n");
        }
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
