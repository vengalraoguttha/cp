package atcoder_bc_178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    static long binomialCoeff(long n, long k, long MOD)
    {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of
        // [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
            res %= MOD;
        }

        return res;
    }


    private static long calculate(int current, int sum, int limit, long[][] dp, long MOD){
        if(current == limit && sum == 0) return 1;
        if(current >= limit) return 0;
        if(sum == 0) {
            dp[current][sum] = 1;
            return 1;
        }
        if(dp[current][sum] != -1) return dp[current][sum];
        long ways = 0;
        for(int i = 0; i <= sum; i++){
            ways += calculate(current + 1, sum - i, limit, dp, MOD);
            ways %= MOD;
        }
        dp[current][sum] = ways;
        return ways;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int a = fr.nextInt();
        int max = a/3;
        long MOD = 1000000007;
        long ways = 0;
        for(int i = 1; i <= max; i++){
            int req = a - i*3;
            long[][] dp = new long[i][req + 1];
            for(int j = 0; j < i; j++){
                Arrays.fill(dp[j], -1);
            }
            ways += calculate(0, req, i, dp, MOD);
            System.out.println(ways);
        }
        sb.append(ways);
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
