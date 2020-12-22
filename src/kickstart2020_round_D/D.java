package kickstart2020_round_D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    private static String solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.second - o2.second;
                }
            });
            int room = 1;
            if(room == y){
                sb.append(x).append(" ");
                continue;
            }
            boolean[] visited = new boolean[n];
            visited[x - 1] = true;
            if(x == 1) {
                pq.add(new Pair(x, arr[x]));
                visited[x] = true;
            }
            else if(x == n){
                pq.add(new Pair(x - 1, arr[x - 2]));
                visited[x - 2] = true;
            }
            else {
                pq.add(new Pair(x + 1, arr[x - 1]));
                pq.add(new Pair(x - 1, arr[x - 2]));
                visited[x] = true;
                visited[x - 2] = true;
            }
            while (true){
                room++;
                if(room == y - 1){
                    sb.append(pq.poll().first).append(" ");
                    break;
                }
                Pair p = pq.poll();
                int current = p.first;
                if(current == 0){
                    if(!visited[1]){
                        pq.add(new Pair(2, arr[0]));
                    }
                }else if(current == n - 1){
                    if(!visited[n - 2]){
                        pq.add(new Pair(n - 2, arr[n - 2]));
                    }
                }else{
                    if(!visited[current - 1]){
                        pq.add(new Pair(current - 1, arr[current - 1]));
                    }
                    if(!visited[current + 1]){
                        pq.add(new Pair(current + 1, arr[current]));
                    }
                }
            }
        }
        return sb.toString();
    }

    static class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
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
