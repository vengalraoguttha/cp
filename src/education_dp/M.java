package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static long MOD = 1000000007;
    private static long[][] dp;
    private static boolean[] visited;
    private static long calculate(int current, int[] arr, int k, int total){
        if(current >= arr.length && k == 0) {
            dp[current][k] = 1;
            return 1;
        }
        if(k == 0) {
            dp[current][k] = 1;
            return 1;
        }
        if(current >= arr.length) {
            dp[current][k] = 0;
            return 0;
        }

        if(dp[current][k] != -1) return dp[current][k];

        int min = Math.min(arr[current], k);

        long ans = 0;

        if(!visited[current]){
            visited[current] = true;
            for(int i = 0; i <= total; i++){
                calculate(current + 1, arr, i, total);
            }
            for(int i = 1; i <= total; i++){
                dp[current + 1][i] += dp[current + 1][i - 1];
                //dp[current + 1][i] %= MOD;
            }
        }

        ans += dp[current + 1][k] - (k - min - 1 >= 0 ? dp[current + 1][k - min - 1] : 0);
        ans %= MOD;

        dp[current][k] = ans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int k = fr.nextInt();
        int[] arr = fr.nextIntArray(n);
        dp = new long[n + 1][k + 1];
        visited = new boolean[n];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        sb.append(calculate(0, arr, k, k));
        System.out.print(sb.toString());
    }

    static class FastReader{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
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
