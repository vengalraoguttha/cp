package atcoder_bc_179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {
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

    static long power(long x, long y, long p)
    {

        // Initialize result
        long res = 1;

        // Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x
            // with result
            if (y % 2 == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }

    // Returns n^(-1) mod p
    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }

    // Returns nCr % p using Fermat's
    // little theorem.
    static long nCrModPFermat(int n, int r,
                              long p)
    {

        // Base case
        if (r == 0)
            return 1;

        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        long[] fac = new long[n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[n] * modInverse(fac[r], p)
                % p * modInverse(fac[n - r], p)
                % p)
                % p;
    }

    private static long MOD = 998244353;

    private static long[] dp;
    private static long[] sums;
    private static long calculate(int current, List<Pair<Integer, Integer>> intervals){
        int start = 1;
        int end = current;
        // get the intervals valid in this range
        long ans = 0;
        for(int i = 0; i < intervals.size(); i++){
            int l = intervals.get(i).first;
            int r = intervals.get(i).second;
            if(end < l || start > r) continue;

            int over_l = Math.max(start, l);
            int over_r = Math.min(end, r);
            ans += sums[current - over_l] - ((current - over_r - 1 >= 0) ? sums[current - over_r - 1] : 0);
            ans %= MOD;
        }
        dp[current] = ans;
        sums[current] = dp[current] + (current - 1 >= 0 ? sums[current - 1] : 0);
        return dp[current];
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int k = fr.nextInt();
        int[] arr = new int[n + 2];
        List<Pair<Integer, Integer>> intervals = new ArrayList<>();
        for(int i = 0; i < k; i++){
            int l1 = fr.nextInt();
            int r1 = fr.nextInt();
            intervals.add(new Pair<>(l1, r1));
            arr[l1]++;
            arr[r1 + 1]--;
        }
        for(int i = 1; i < n + 2; i++){
            arr[i] += arr[i - 1];
        }

        dp = new long[n + 2];
        sums = new long[n + 2];
        dp[1] = 1;
        sums[1] = 1;
        for(int i = 2; i <= n; i++){
            calculate(i, intervals);
        }

        sb.append(dp[n]);
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
