package atcoder_bc_178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            a[i] = x + y;
            b[i] = x - y;
            min1 = Math.min(min1, a[i]);
            min2 = Math.min(min2, b[i]);
        }

        long max = Long.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, a[i] - min1);
            max = Math.max(max, b[i] - min2);
        }

        sb.append(max);
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
