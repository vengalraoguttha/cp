package round662_div2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < arr.length; i++){
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for(Integer key : map.keySet()){
                list.add(new Pair<>(key, map.get(key)));
            }
            list.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o2.second - o1.second;
                }
            });
            int count = 1;
            int val = list.get(0).second;
            for(int i = 1; i < list.size(); i++){
                if(list.get(i).second != val) break;
                count++;
            }
            int x = n - count + 1 - list.get(0).second;
            sb.append(x/(list.get(0).second - 1)).append("\n");
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
