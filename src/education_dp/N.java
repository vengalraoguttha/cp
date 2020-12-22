package education_dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class N {
    private static FastReader fr = new FastReader();
    private static PrintWriter out = new PrintWriter(System.out);

    private static long[][] dp;
    private static long calculate(int start, int end, long[] sums){
        if(dp[start][end] != -1) return dp[start][end];
        if(start == end){
            dp[start][end] = 0;
            return dp[start][end];
        }
        long ans = Long.MAX_VALUE;
        for(int i = start; i < end; i++){
            long x = calculate(start, i, sums);
            long y = calculate(i + 1, end, sums);
            ans = Math.min(ans, x + y + sums[i] - (start - 1 >= 0 ? sums[start - 1] : 0) + sums[end] - sums[i]);
        }
        dp[start][end] = ans;
        return dp[start][end];
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int[] arr = fr.nextIntArray(n);

        long[] sums = new long[n];
        sums[0] = arr[0];
        for(int i = 1; i < n; i++){
            sums[i] = sums[i - 1] + arr[i];
        }
        dp = new long[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        sb.append(calculate(0, n - 1, sums));
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
