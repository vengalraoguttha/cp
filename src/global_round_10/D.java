package global_round_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            String s = br.readLine();
            List<Pair<Character, Integer>> pairs = new ArrayList<>();
            char ch = s.charAt(0);
            int count = 0;
            int start = 0;
            for(int i = 1; i < n; i++){
                if(s.charAt(i) != s.charAt(i - 1)){
                    start = i;
                    break;
                }
            }
            if(start == 0){
                if(n < 3){
                    sb.append(0).append("\n");
                }else
                sb.append((int) Math.ceil(n*1.0/3)).append("\n");
                continue;
            }
            for(int i = start; i < n; i++){
                if(ch != s.charAt(i)){
                    if(count != 0){
                        pairs.add(new Pair<>(ch, count));
                    }
                    count = 1;
                    ch = s.charAt(i);
                } else
                count++;
            }

            for(int i = 0; i < start; i++){
                if(ch != s.charAt(i)){
                    if(count != 0){
                        pairs.add(new Pair<>(ch, count));
                    }
                    count = 1;
                    ch = s.charAt(i);
                } else
                count++;
            }

            if(count != 0){
                pairs.add(new Pair<>(ch, count));
            }

            int ans = 0;
            for(Pair<Character, Integer> pair : pairs){
                ans += (pair.second/3);
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

