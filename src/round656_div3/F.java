package round656_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new ArrayList[n];
            Map<Integer, Integer> indegreeMap = new HashMap<>();
            for(int i = 0; i < n - 1; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(graph[x - 1] == null) graph[x - 1] = new ArrayList<>();
                if(graph[y - 1] == null) graph[y - 1] = new ArrayList<>();
                graph[x - 1].add(y - 1);
                graph[y - 1].add(x - 1);
                indegreeMap.put(x - 1, indegreeMap.getOrDefault(x - 1, 0) + 1);
                indegreeMap.put(y - 1, indegreeMap.getOrDefault(y - 1, 0) + 1);
            }

            if(k == 1){
                sb.append(n - 1).append("\n");
                continue;
            }
            int moves = 0;
            List<Pair<Integer, Integer>> pairList = new ArrayList<>();
            for(int key : indegreeMap.keySet()){
                pairList.add(new Pair<>(key, indegreeMap.get(key)));
            }

            pairList.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.second - o2.second;
                }
            });

            Map<Integer, Integer> map = new HashMap<>();
            for(Pair<Integer, Integer> pair : pairList){
                if(pair.second != 1) continue;
                map.put(graph[pair.first].get(0), map.getOrDefault(graph[pair.first].get(0), 0) + 1);
            }


            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o2.second - o1.second;
                }
            });
            for(int key : map.keySet()){
                pq.add(new Pair<>(key, map.get(key)));
            }
            while (true){
                int key = pq.peek().first;
                int val = pq.peek().second;
                if(val >= k){
                    moves++;
                    map.put(key, map.get(key) - k);
                    pq.poll();
                    pq.add(new Pair<>(key, map.get(key)));
                    indegreeMap.put(key, indegreeMap.get(key) - k);
                    if(indegreeMap.get(key) == 1 && graph[key] != null){
                        for(int next : graph[key]){
                            if(indegreeMap.get(next) > 1){
                                Integer vv = map.get(next);
                                map.put(next, map.getOrDefault(next, 0) + 1);
                                if(vv != null){
                                    pq.remove(new Pair<>(next, vv));
                                }
                                pq.add(new Pair<>(next, map.get(next)));
                            }
                        }
                    }
                }else {
                    break;
                }
            }
            sb.append(moves).append("\n");
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

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Pair){
                Pair<Integer, Integer> pair = (Pair) obj;
                if(pair.first == first && pair.second == second) return true;
                else return false;
            }
            return super.equals(obj);
        }
    }
}
