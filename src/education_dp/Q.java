package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static long[] dp;

    private static long[] table;

    private static long max(int till){
        long max = 0;
        while (till >= 0){
            max = Math.max(max, table[till]);
            till = (till & (till + 1)) - 1;
        }
        return max;
    }

    private static void set(int pos, long val){
        while (pos < table.length){
            table[pos] = Math.max(table[pos], val);
            pos = (pos | (pos + 1));
        }
    }

    private static long calculate(int current, int[] h, int[] a){
        dp[current] = a[current] + max(h[current] - 1);
        set(h[current], dp[current]);
        return dp[current];
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int[] h = fr.nextIntArray(n);
        int[] a = fr.nextIntArray(n);
        int size = 1;
        while (size < n){
            size <<= 1;
        }
        dp = new long[size + 10];
        table = new long[size + 10];
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, calculate(i, h, a));
        }
        sb.append(ans);
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
