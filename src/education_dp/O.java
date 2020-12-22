package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class O {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static long MOD = 1000000007;

    private static long[][] dp;

    private static int[][] arr;

    private static long calculate(int men, int women, int n){
        if(men == n) return 1;
        if(dp[men][women] != -1) return dp[men][women];
        long ans = 0;
        for(int i = 0; i < n; i++){
            int bit = getBit(women, i);
            if(bit == 0 && arr[men][i] == 1){
                ans += calculate(men + 1, setBit(women, i), n);
                ans %= MOD;
            }
        }
        dp[men][women] = ans;
        return ans;
    }

    private static int getBit(int value, int position){
        return (value >> position) & 1;
    }

    private static int setBit(int value, int position){
        int filter = 1 << position;
        return value | filter;
    }

    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextIntArray(n);
        }
        dp = new long[n][1 << (n + 1)];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        sb.append(calculate(0, 0, n));
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
