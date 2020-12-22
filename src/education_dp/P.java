package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static long MOD = 1000000007;

    private static long[][] dp;
    private static long calculate(List<Integer>[] graph, int current, int parentColor, boolean[] visited){
        if(dp[current][parentColor] != -1) return dp[current][parentColor];
        visited[current] = true;
        long ans = 0;
        boolean isLeaf = true;
        if(graph[current] != null){
            long whites = 1;
            for(int next : graph[current]){
                if(!visited[next]){
                    isLeaf = false;
                    whites *= calculate(graph, next, 0, visited);
                    whites %= MOD;
                }
            }
            long blacks = parentColor == 0 ? 1 : 0;
            for(int next : graph[current]){
                if(!visited[next] && parentColor == 0){
                    blacks *= calculate(graph, next, 1, visited);
                    blacks %= MOD;
                }
            }
            ans += whites + blacks;
            ans %= MOD;
        }
        if(isLeaf){
            if(parentColor == 0) ans = 2;
            else ans = 1;
        }
        visited[current] = false;
        dp[current][parentColor] = ans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n - 1; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
            if(graph[y - 1] == null) graph[y - 1] = new ArrayList<>();
            graph[x - 1].add(y - 1);
            graph[y - 1].add(x - 1);
        }
        boolean[] visited = new boolean[n];
        dp = new long[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        sb.append(calculate(graph, 0, 0, visited));
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
