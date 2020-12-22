package round656_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    private static void dfs(List<Integer>[] graph, int current , int parent, boolean[] visited, Stack<Integer> stack){
        visited[current] = true;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    dfs(graph, next, current, visited, stack);
                }
            }
        }
        stack.add(current);
    }
    private static boolean dfsCycleCheck(List<Integer>[] graph, int current , int parent, boolean[] visited, boolean[] stack){
        visited[current] = true;
        stack[current] = true;
        boolean ans = true;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    stack[next] = true;
                    ans = ans && dfsCycleCheck(graph, next, current, visited, stack);
                }else {
                    if(next != parent && stack[next]){
                        // back edge
                        return false;
                    }
                }
            }
        }
        stack[current] = false;
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new ArrayList[n];
            List<Pair<Integer, Integer>> unDirectedEdges = new ArrayList<>();
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(type == 0){
                    unDirectedEdges.add(new Pair<>(x, y));
                }else {
                    if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
                    graph[x - 1].add(y - 1);
                }
            }
            boolean[] visited = new boolean[n];
            boolean[] stack = new boolean[n];
            boolean ans = true;
            for(int i = 0; i < n; i++){
                ans = ans && dfsCycleCheck(graph, i, -1, visited, stack);
            }

            if(!ans){
                sb.append("NO\n");
                continue;
            }

            Arrays.fill(visited, false);

            Stack<Integer> stac = new Stack<>();
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    dfs(graph, i, -1, visited, stac);
                }
            }
            Map<Integer, Integer> map = new HashMap<>();
            int current = 0;
            while (!stac.isEmpty()){
                map.put(stac.pop(), current);
                current++;
            }
            sb.append("YES\n");
            for(int i = 0; i < n; i++){
                if(graph[i] != null)
                    for(int next : graph[i]){
                        sb.append(i+1).append(" ").append(next + 1).append("\n");
                    }
            }
            for(Pair<Integer, Integer> pair : unDirectedEdges){
                if(map.get(pair.first - 1) > map.get(pair.second - 1)){
                    sb.append(pair.second).append(" ").append(pair.first).append("\n");
                }else {
                    sb.append(pair.first).append(" ").append(pair.second).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
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
