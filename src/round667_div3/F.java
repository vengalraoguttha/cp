package round667_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static long[][][] dp;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int k = fr.nextInt();
        String s = fr.next();
        String t =fr.next();

        dp = new long[n][n+1][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n + 1; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        sb.append(calculate(0, 0, k, n, s, t));
        System.out.print(sb.toString());
    }

    private static long calculate(int current, int first, int count, int n, String s, String t){
        if(current >= n) return 0;
        if(dp[current][first][count] != -1) return dp[current][first][count];
        if(t.charAt(0) == t.charAt(1)){
            int match = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == t.charAt(0) || s.charAt(i) == t.charAt(1)){
                    match++;
                }
            }
            int remaining = n - match;
            int filled = Math.min(remaining, count);
            dp[current][first][count] = ((filled + match)*((long) (filled + match - 1)))/2;
            return dp[current][first][count];
        } else {
            long x = Long.MIN_VALUE;
            if(s.charAt(current) != t.charAt(0) && count > 0){
                x = calculate(current + 1, first + 1, count - 1, n, s, t);
            }

            long y = Long.MIN_VALUE;
            if(s.charAt(current) != t.charAt(1) && count > 0){
                y = ((long) first) + calculate(current + 1, first, count - 1, n, s, t);
            }

            long z = Long.MIN_VALUE;
            if(s.charAt(current) == t.charAt(0)) {
                z = calculate(current + 1, first + 1, count, n, s, t);
            } else if(s.charAt(current) == t.charAt(1)) {
                z = first + calculate(current + 1, first, count, n, s, t);
            } else {
                z = calculate(current + 1, first, count, n, s, t);
            }

            dp[current][first][count] = Math.max(x, Math.max(y, z));
            return dp[current][first][count];
        }
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
