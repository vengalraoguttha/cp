package round661_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    private static int process(HashMap<Integer, List<Integer>> hashMap, int[] arr, boolean[] visited, int sum){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;
            if(sum - arr[i] <= 0) continue;
            int val = sum - arr[i];
            visited[i] = true;
            if(!hashMap.containsKey(val)) continue;
            for(int index : hashMap.get(val)){
                if(visited[index]) continue;
                visited[index] = true;
                count = Math.max(count, 1 + process(hashMap, arr, visited, sum));
                visited[index] = false;
            }
            visited[i] = false;
        }
        return count;
    }
    private static int calculate(int[] arr, int sum){
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    list.add(new Pair<>(i, j));
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }
        boolean[] visited = new boolean[arr.length];
        int count = 0;
        for(Pair<Integer, Integer>pair : list){
            if(map.get(pair.first) == 1 || map.get(pair.second) == 1){
                if(!visited[pair.first] && !visited[pair.second]){
                    count++;
                    visited[pair.first] = true;
                    visited[pair.second] = true;
                }
            }
        }
        for(Pair<Integer, Integer>pair : list){
            if(!visited[pair.first] && !visited[pair.second]){
                count++;
                visited[pair.first] = true;
                visited[pair.second] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            int ans = Integer.MIN_VALUE;
            for(int i = 2; i <= 100; i++){
                ans = Math.max(ans, calculate(arr, i));
            }
            sb.append(ans).append("\n");
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
