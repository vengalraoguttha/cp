package round675_div2;

import education_dp.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int m = fr.nextInt();
            long[][] arr = new long[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    arr[i][j] = fr.nextInt();
                }
            }
            boolean[][] visited = new boolean[n][m];
            long ans = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    visited[n - 1 - i][j] = true;
                    visited[i][m - 1 - j] = true;
                    visited[n - 1 - i][m - 1 - j] = true;
                    if(i == n - 1 - i && j == m - 1 - j){
                        continue;
                    } else if(i == n - 1 - i){
                        long x1 = arr[i][j];
                        long x2 = arr[i][m - 1 - j];
                        long v1 = Math.abs(x1 - x1) + Math.abs(x2 - x1);
                        long v2 = Math.abs(x1 - x2) + Math.abs(x2 - x2);
                        ans += Math.min(v1, v2);
                        continue;
                    } else if(j == m - 1 - j){
                        long x1 = arr[i][j];
                        long x2 = arr[n - 1 - i][j];
                        long v1 = Math.abs(x1 - x1) + Math.abs(x2 - x1);
                        long v2 = Math.abs(x1 - x2) + Math.abs(x2 - x2);
                        ans += Math.min(v1, v2);
                        continue;
                    }

                    long x1 = arr[i][j];
                    long x2 = arr[n - 1 - i][j];
                    long x3 = arr[i][m - 1 - j];
                    long x4 = arr[n - 1 - i][m - 1 - j];
                    long min = Math.min(x1, Math.min(x2, Math.min(x3, x4)));
                    long max = Math.max(x1, Math.max(x2, Math.max(x3, x4)));
                    if(min == max){
                        continue;
                    }
                    long v1 = Math.abs(x1 - x1) + Math.abs(x2 - x1) + Math.abs(x3 - x1) + Math.abs(x4 - x1);
                    long v2 = Math.abs(x1 - x2) + Math.abs(x2 - x2) + Math.abs(x3 - x2) + Math.abs(x4 - x2);
                    long v3 = Math.abs(x1 - x3) + Math.abs(x2 - x3) + Math.abs(x3 - x3) + Math.abs(x4 - x3);
                    long v4 = Math.abs(x1 - x4) + Math.abs(x2 - x4) + Math.abs(x3 - x4) + Math.abs(x4 - x4);
                    ans += Math.min(v1, Math.min(v2, Math.min(v3, v4)));
                }
            }
            sb.append(ans).append("\n");
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
