package educational_round93;

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
            String s = br.readLine();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                int val = s.charAt(i) - '0';
                arr[i] = val - 1;
            }

            for(int i = 1; i < n; i++){
                arr[i] += arr[i - 1];
            }

            long ans = 0;
            HashMap<Integer, Integer> counts = new HashMap<>();
            for(int i = 0; i < n; i++){
                counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
                if(arr[i] == 0)
                ans += counts.getOrDefault(arr[i], 0);
                else ans += counts.getOrDefault(arr[i], 0) - 1;
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
