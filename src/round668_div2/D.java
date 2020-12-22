package round668_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    static int[] depthG;

    private static void  dfs(List<Integer>[] graph, int current, boolean[] visited, int depth){
        visited[current] = true;
        depthG[current] = depth;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    dfs(graph, next, visited, depth + 1);
                }
            }
        }
    }

    private static boolean cutGraph(List<Integer>[] graph, int current, boolean[] visited, int req){
        if(req == current) return true;
        visited[current] = true;
        boolean has = false;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(next == req) return true;
                if(!visited[next]){
                    visited[next] = true;
                    has = has || cutGraph(graph, next, visited, req);
                }
            }
        }
        return has;
    }

    private static void process(List<Integer>[] graph, int current, boolean[] visited, int req){
        visited[current] = true;
        List<Integer> integerList = new ArrayList<>();
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    boolean res = cutGraph(graph, next, visited, req);
                    if(res){
                        integerList.add(next);
                    }
                }
            }
            graph[current].clear();
            graph[current].addAll(integerList);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int a = fr.nextInt();
            int b = fr.nextInt();
            int da = fr.nextInt();
            int db = fr.nextInt();
            List<Integer>[] graph = new ArrayList[n];
            for(int i = 0; i < n - 1; i++){
                int x = fr.nextInt();
                int y = fr.nextInt();
                if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
                if(graph[y - 1] == null) graph[y - 1] = new ArrayList<>();
                graph[x - 1].add(y - 1);
                graph[y - 1].add(x - 1);
            }
            if(da == 0){
                sb.append("Bob\n");
                continue;
            }
            boolean[] visited = new boolean[n];
            //process(graph, a - 1, visited, b - 1);
            if(db < 2 + da){
                sb.append("Alice\n");
                continue;
            }
            depthG = new int[n];

            Arrays.fill(visited, false);
            dfs(graph, a - 1, visited, 0);

            if(depthG[b - 1] <= da){
                sb.append("Alice\n");
                continue;
            }

            Arrays.fill(visited, false);
            dfs(graph, 0, visited, 0);
            int maxDepth = Integer.MIN_VALUE;
            int farNode = -1;
            for(int i = 0; i < n; i++){
                if(maxDepth < depthG[i]){
                    maxDepth = depthG[i];
                    farNode = i;
                }
            }

            Arrays.fill(visited, false);
            dfs(graph, farNode, visited, 0);
            maxDepth = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                maxDepth = Math.max(maxDepth, depthG[i]);
            }

            int min = Math.min(maxDepth, db);
            if(min < 2 + da){
                sb.append("Alice\n");
            } else {
                sb.append("Bob\n");
            }
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
}
