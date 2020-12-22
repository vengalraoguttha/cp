package atcoder_bc_177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    private static int dfs(int current, Set<Integer>[] graph, boolean[] visited){
        visited[current] = true;
        int count = 1;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    count += dfs(next, graph, visited);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int n = in[0];
        int m = in[1];
        Set<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < m; i++){
            int[] arr = nextIntArray(br, 2);
            if(graph[arr[0] - 1] == null) graph[arr[0] - 1] = new HashSet<>();
            if(graph[arr[1] - 1] == null) graph[arr[1] - 1] = new HashSet<>();
            graph[arr[0] - 1].add(arr[1] - 1);
            graph[arr[1] - 1].add(arr[0] - 1);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ans = Math.max(ans, dfs(i, graph, visited));
            }
        }
        sb.append(ans);
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
