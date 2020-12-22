package kickstart2020_round_D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    private static HashMap<Integer, List<Integer>> dfs(ArrayList<Integer>[] graph, double[] counts, int current, int a, int level, boolean[] visited){
        if(graph[current] == null || graph[current].size() == 0){
            counts[current]++;
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(current);
            map.put(level, list);
            return map;
        }
        visited[current] = true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int next : graph[current]){
            if(!visited[next]){
                HashMap<Integer, List<Integer>> m = dfs(graph, counts, next, a, level + 1, visited);
                for(int key : m.keySet()){
                    List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                    list.addAll(m.get(key));
                    map.put(key, list);
                }
            }
        }

        counts[current]++;
        List<Integer> levelList = map.getOrDefault(level, new ArrayList<>());
        levelList.add(current);
        map.put(level, levelList);

        if(map.containsKey(level + a)){
            for(Integer index : map.get(level + a)){
                counts[current] += counts[index];
            }
        }

        return map;
    }

    private static double solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n - 1];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n - 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(graph[arr[i] - 1] == null) graph[arr[i] - 1] = new ArrayList<>();
            if(graph[i + 1] == null) graph[i + 1] = new ArrayList<>();
            graph[arr[i] - 1].add(i + 1);
            graph[i + 1].add(arr[i] - 1);
        }

        double[] c1 = new double[n];
        double[] c2 = new double[n];
        boolean[] visited = new boolean[n];
        dfs(graph, c1, 0, a, 0, visited);
        Arrays.fill(visited, false);
        dfs(graph, c2, 0, b, 0, visited);

        double total = 0;

        for(int i = 0; i < n; i++){
            total += (n*c1[i] + n*c2[i]) - c1[i]*c2[i];
        }

        return total/(((long)n)*n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= t; i++){
            sb.append("Case #").append(i).append(": ").append(solve(br)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
