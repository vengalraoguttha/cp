package round670_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static int process(int[][] counts, int current, List<Integer>[] graph, int parent, int n){
        if(graph[current] != null){
            int max = 0;
            int total = 0;
            int maxChild = -1;
            for(int next : graph[current]){
                if(next != parent){
                    int child = process(counts, next, graph, current, n);
                    if(max < child){
                        max = child;
                        maxChild = next;
                    }
                    total += child;
                }
            }
            int remaining = n - total - 1;
            if(max < remaining){
                max = remaining;
                maxChild = parent;
            }
            counts[current][0] = max;
            counts[current][1] = maxChild;
            return total + 1;
        }
        counts[current][0] = n - 1;
        counts[current][1] = parent;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int[] degree = new int[n];
            List<Integer>[] graph = new ArrayList[n];
            for(int i = 0; i < n - 1; i++){
                int x = fr.nextInt();
                int y = fr.nextInt();
                degree[x - 1]++;
                degree[y - 1]++;
                if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
                if(graph[y - 1] == null) graph[y - 1] = new ArrayList<>();
                graph[x - 1].add(y - 1);
                graph[y - 1].add(x - 1);
            }

            int[][] counts = new int[n][2];

            process(counts, 0, graph, -1, n);

            int min = counts[0][0];
            int ind = 0;
            int c = 1;
            int mC1 = counts[0][1];
            for(int i = 1; i < n; i++){
                if(min > counts[i][0]){
                    min = counts[i][0];
                    ind = i;
                    mC1 = counts[i][1];
                    c = 1;
                } else if(min == counts[i][0]){
                    c++;
                }
            }

            if(c == 1){
                // remove and add same edge
                int oneDegree = 0;
                for(int i = 0; i < n; i++){
                    if(degree[i] == 1){
                        oneDegree = i;
                        break;
                    }
                }
                int p = graph[oneDegree].get(0);
                sb.append((p + 1)).append(" ").append((oneDegree + 1)).append("\n");
                sb.append((p + 1)).append(" ").append((oneDegree + 1)).append("\n");
            } else {
                boolean[] visited = new boolean[n];
                int leaf = dfs(ind, mC1, graph, visited);
                int p = graph[leaf].get(0);
                sb.append((p + 1)).append(" ").append((leaf + 1)).append("\n");
                sb.append((leaf + 1)).append(" ").append(mC1 + 1).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static int dfs(int current, int ignore, List<Integer>[] graph, boolean[] visited){
        visited[current] = true;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(next != ignore && !visited[next]){
                    visited[next] = true;
                    return dfs(next, ignore, graph, visited);
                }
            }
        }
        return current;
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
