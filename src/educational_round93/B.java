package educational_round93;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            String s = br.readLine();
            List<Integer> list = new ArrayList<>();
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    count++;
                }else {
                    if(count > 0){
                        list.add(count);
                        count = 0;
                    }
                }
            }
            if(count > 0) list.add(count);
            list.sort(null);
            int score = 0;
            for(int i = list.size() - 1; i >= 0; i -= 2){
                score += list.get(i);
            }
            sb.append(score).append("\n");
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

