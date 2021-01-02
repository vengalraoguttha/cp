package leetcode_weekly_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private int[][][] dp;

    private int[][] dp2;

    private int calculate(int current,int[] sums, int remaining, int previous){
        // can split a group at current or can move forward
        if(remaining == 1){
            return sums[sums.length - 1] - sums[previous];
        }
        if(current == sums.length){
            return Integer.MAX_VALUE;
        }
        if(dp[current][previous][remaining] != -1){
            return dp[current][previous][remaining];
        }
        int currentSum = sums[current] - sums[previous];
        int res1 = Math.max(currentSum, calculate(current + 1, sums, remaining - 1, current));
        int res2 = calculate(current + 1, sums, remaining, previous);
        dp[current][previous][remaining] = Math.min(res1, res2);
        return dp[current][previous][remaining];
    }

    private int calculate2(int current,int[] sums, int remaining){
        // min -> dp[0... current-1][remaining - 1]
        if(remaining == 1){
            return sums[current];
        }
        if(current == 0){
            return Integer.MAX_VALUE;
        }
        if(dp2[current][remaining] != -1) return dp2[current][remaining];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < current; i++){
            ans = Math.min(ans, Math.max(sums[current] - sums[i], calculate2(i, sums, remaining - 1)));
        }
        dp2[current][remaining] = ans;
        return ans;
    }

    public int splitArray(int[] nums, int m) {
        dp2 = new int[nums.length + 1][m + 2];
        for(int i = 0; i <= nums.length; i++){
            Arrays.fill(dp2[i], -1);
        }
        int[] sums = new int[nums.length + 1];
        sums[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            sums[i] += sums[i - 1] + nums[i - 1];
        }

        return calculate2(nums.length, sums, m);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        C c = new C();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[] arr = fr.nextIntArray(n);
        System.out.println(c.splitArray(arr, m));
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

    static long mod(String num, long a)
    {
        // Initialize result
        long res = 0;

        // One by one process all digits of 'num'
        for (int i = 0; i < num.length(); i++)
            res = (res*10 +  num.charAt(i) - '0') %a;

        return res;
    }

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
}
