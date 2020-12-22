package kickstart_round_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static int getNode(int i, int j){
        return (i - 1) * (i - 1) + j;
    }

    private static long count(int current, List<Integer>[] graph, List<Integer> underConstruction, boolean[] visited, boolean[] stack){
        visited[current] = true;
        int count = !stack[current] ? 1 : 0;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next] && !underConstruction.contains(next)){
                    visited[next] = true;
                    count += count(next, graph, underConstruction, visited, stack);
                }
            }
        }
        return count;
    }

    private static long calculate(int a, int b, List<Integer>[] graph, List<Integer> underConstruction, int turn, boolean[] stack, boolean flag){
        if(turn == 0){
            //player 1
            if(flag){
                boolean[] visited = new boolean[stack.length];
                long x = count(a, graph, underConstruction, visited, stack);
                return x;
            }
            stack[a] = true;
            long count = Long.MIN_VALUE;
            boolean used = false;
            if(graph[a] != null){
                for(int next : graph[a]){
                    if(!stack[next] && !underConstruction.contains(next)){
                        used = true;
                        stack[next] = true;
                        count = Math.max(count, calculate(next, b, graph, underConstruction, 1, stack, false));
                        stack[next] = false;
                    }
                }
            }

            if(!used){
                count = Math.max(count, calculate(a, b, graph, underConstruction, 1, stack, true));
            }
            return count + 1;
        } else {
            // player 2
            if(flag){
                boolean[] visited = new boolean[stack.length];
                long x = -count(b, graph, underConstruction, visited, stack);
                x--;
                return x;
            }
            stack[b] = true;
            long count = Long.MAX_VALUE;
            boolean used = false;
            if(graph[b] != null){
                for(int next : graph[b]){
                    if(!stack[next] && !underConstruction.contains(next)){
                        used = true;
                        stack[next] = true;
                        count = Math.min(count, calculate(a, next, graph, underConstruction, 0, stack, false));
                        stack[next] = false;
                    }
                }
            }

            if(!used){
                count = Math.min(count, calculate(a, b, graph, underConstruction, 0, stack, true));
            }
            return count - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        int test = 1;
        while (t-- > 0){
            int s = fr.nextInt();
            int ra = fr.nextInt();
            int pa = fr.nextInt();
            int rb = fr.nextInt();
            int pb = fr.nextInt();
            int c = fr.nextInt();
            int size = getNode(s, 2*s - 1);
            List<Integer>[] graph = new ArrayList[size];
            for(int i = 1; i <= s; i++){
                for(int j = 2; j <= 2*i - 1; j++){
                    int x = getNode(i, j);
                    int y = getNode(i, j - 1);
                    if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
                    if(graph[y - 1] == null) graph[y - 1] = new ArrayList<>();
                    graph[x - 1].add(y - 1);
                    graph[y -1 ].add(x - 1);
                }
            }
            for(int i = 2; i <= s; i++){
                for(int j = 2; j <= 2*i - 1; j+=2){
                    int x = getNode(i, j);
                    int y = getNode(i - 1, j - 1);
                    if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
                    if(graph[y - 1] == null) graph[y - 1] = new ArrayList<>();
                    graph[x - 1].add(y - 1);
                    graph[y -1 ].add(x - 1);
                }
            }
            List<Integer> underConstruction = new ArrayList<>();
            for(int i = 0; i < c; i++){
                int x = fr.nextInt();
                int y = fr.nextInt();
                underConstruction.add(getNode(x, y) - 1);
            }

            int a = getNode(ra, pa) - 1;
            int b = getNode(rb, pb) - 1;

            sb.append("Case #").append(test).append(": ");
            boolean[] stack = new boolean[size + 1];
            stack[a] = true;
            stack[b] = true;
            sb.append(calculate(a, b, graph, underConstruction, 0, stack, false)).append("\n");
            test++;
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
