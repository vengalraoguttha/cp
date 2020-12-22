package round660_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    private static Pair<Long, Boolean> dfs(List<Integer>[] graph, int current, boolean[] visited, int[] p, int[] h){
        visited[current] = true;
        long count = 0;
        if(graph[current]  != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    Pair<Long, Boolean> pair = dfs(graph, next, visited, p, h);
                    if(!pair.second) {
                        return pair;
                    }
                    count += pair.first;
                }
            }
        }

        if(p[current] + count < h[current] || -(p[current] + count) > h[current]) {
            return  new Pair(0, false);
        }
        if(((Math.abs(p[current] + count - h[current])) % 2 == 0)){
            count += p[current];
            return new Pair<>(count, true);
        }
        return new Pair(0, false);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] arr = nextIntArray(br, 2);
            int n = arr[0];
            int m = arr[1];
            int[] p = nextIntArray(br, n);
            int[] h = nextIntArray(br, n);
            List<Integer>[] graph = new ArrayList[n];
            for(int i = 0; i < n - 1; i++){
                int[] edge = nextIntArray(br, 2);
                if(graph[edge[0] - 1] == null) graph[edge[0] - 1] = new ArrayList<>();
                if(graph[edge[1] - 1] == null) graph[edge[1] - 1] = new ArrayList<>();
                graph[edge[0] - 1].add(edge[1] - 1);
                graph[edge[1] - 1].add(edge[0] - 1);
            }
            boolean[] visited = new boolean[n];
            Pair<Long, Boolean> pair = dfs(graph, 0, visited, p, h);
            if(pair.second){
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static int nextInt(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }

    private static int[] nextIntArray(BufferedReader br, int n) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
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

