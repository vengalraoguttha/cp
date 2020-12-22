package round685_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static int[][][][] dp;

    private static boolean calculate(String s, int current, int notContinuous, int i, int j, int a){
        if(i > j){
            return notContinuous == 1;
        }
        if(current == s.length()){
            return false;
        }
        if(dp[current][notContinuous][i][j] != -1){
            if(dp[current][notContinuous][i][j] == 0) return false;
            return true;
        }
        if(notContinuous == 0){
            if(s.charAt(current) == s.charAt(i)){
                boolean r1 = calculate(s, current + 1, (i == a) ? 0 : 1, i, j, a);
                boolean r2 = calculate(s, current + 1, 0, i + 1, j, a);
                if(r1 || r2){
                    dp[current][notContinuous][i][j] = 1;
                } else {
                    dp[current][notContinuous][i][j] = 0;
                }
                return r1 || r2;
            } else {
                boolean r1 = calculate(s, current + 1, (i == a) ? 0 : 1, i, j, a);
                if(r1){
                    dp[current][notContinuous][i][j] = 1;
                } else {
                    dp[current][notContinuous][i][j] = 0;
                }
                return r1;
            }
        } else {
            if(s.charAt(current) == s.charAt(i)){
                boolean r1 = calculate(s, current + 1, 1, i, j, a);
                boolean r2 = calculate(s, current + 1, 1, i + 1, j, a);
                if(r1 || r2){
                    dp[current][notContinuous][i][j] = 1;
                } else {
                    dp[current][notContinuous][i][j] = 0;
                }
                return r1 || r2;
            } else {
                boolean r1 = calculate(s, current + 1, 1, i, j, a);
                if(r1){
                    dp[current][notContinuous][i][j] = 1;
                } else {
                    dp[current][notContinuous][i][j] = 0;
                }
                return r1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int q = fr.nextInt();
            String s = fr.next();
            dp = new int[n][2][n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < 2; j++){
                    for(int k = 0; k < n; k++){
                        Arrays.fill(dp[i][j][k], -1);
                    }
                }
            }

            for(int a = 0; a < q; a++){
                int l = fr.nextInt();
                int r = fr.nextInt();
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < 2; j++){
                        for(int k = 0; k < n; k++){
                            Arrays.fill(dp[i][j][k], -1);
                        }
                    }
                }
                boolean res = calculate(s, 0, 0, l - 1, r - 1, l - 1);
                if(res)
                sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
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
