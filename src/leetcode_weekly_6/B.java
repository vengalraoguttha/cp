package leetcode_weekly_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private String getVal(int val) throws Exception {
        if(val < 10) return String.valueOf(val);
        if(val <= 15){
            if(val == 10) return "a";
            if(val == 11) return "b";
            if(val == 12) return "c";
            if(val == 13) return "d";
            if(val == 14) return "e";
            return "f";
        }
        throw new Exception("Unexpected input");
    }

    public String toHex(int num) throws Exception {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int current = 0;
        int[] bits = new int[32];
        int limit = 0;
        for(int i = 0; i < 32; i++){
            bits[i] = num & 1;
            num >>= 1;
            limit = i;
            if(num == 0) break;
        }
        int start = 0;
        while (start <= limit){
            int bit = bits[start];
            start++;
            current += bit * (1 << count);
            count++;
            if(count == 4){
                sb.insert(0, getVal(current));
                current = 0;
                count = 0;
            }
        }
        if(current > 0){
            sb.insert(0, getVal(current));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException, Exception {
        StringBuilder sb = new StringBuilder();
        // code goes here
        B b = new B();
        System.out.printf(b.toHex(fr.nextInt()));
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
