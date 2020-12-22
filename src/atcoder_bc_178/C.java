package atcoder_bc_178;

import education_dp.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static long pow(long a, long b, long MOD){
        if(b < 0) return 0;
        if(a == 0) return 0;
        if(b == 1) return a;
        if(b == 0) return 1;
        long v = pow(a, b/2, MOD);
        if(b % 2 == 0){
            return (v * v) % MOD;
        } else {
            return (((v * a) % MOD)*v)%MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        long n = fr.nextInt();
        long MOD = 1000000007;

        long val = pow(10, n, MOD);
        val += 2*MOD;
        val += pow(8, n, MOD);
        val -= 2*pow(9, n, MOD);
        val %= MOD;
        sb.append(val);

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
