package leetcode_weekly_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public boolean validUtf8(int[] data){
        return validUtf8(data, 0);
    }

    public boolean validUtf8(int[] data, int current) {
        if(current >= data.length) return true;
        if(data.length == 0) return false;
        if(data.length == 1){
            if(data[0] < 128){
                return true;
            }
            return false;
        }

        StringBuilder bits = new StringBuilder();
        int val = data[current];
        if(val < 128){
            return validUtf8(data, current + 1);
        }
        while (val > 0){
            bits.append(val & 1);
            val >>= 1;
        }
        bits = bits.reverse();

        int count = 0;
        boolean flag = false;
        for(int i = 0; i < bits.length(); i++){
            if(bits.charAt(i) == '1' && !flag) count++;
            else if(bits.charAt(i) != '1') flag = true;
        }

        if(!flag) return false;

        if(count < 2 || count > 5) {
            if(count != 0) return false;
        }

        for(int i = current + 1; i < current + count; i++){
            if(i >= data.length) return false;
            if(data[i] < 128 || data[i] > 191) return false;
        }

        int x = (count > 0) ? count : 1;

        return validUtf8(data, current + x);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        B b = new B();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        System.out.println(b.validUtf8(arr));
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
