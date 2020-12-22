package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G {
    private static int dfs(int current, Set<Integer>[] graph, int[] counts){
        if(counts[current] == -1){
            counts[current] = 1;
        }
        int max = 0;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(counts[next] == -1){
                    max = Math.max(max, dfs(next, graph, counts));
                }else {
                    max = Math.max(max, counts[next]);
                }
            }
        }
        counts[current] += max;
        return counts[current];
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
            graph[arr[0] - 1].add(arr[1] - 1);
        }
        int[] counts = new int[n];
        Arrays.fill(counts, -1);
        for(int i = 0; i < n; i++){
            if(counts[i] == -1){
                dfs(i, graph, counts);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, counts[i]);
        }
        sb.append(ans - 1);
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

