package atcoder_bc_177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        String s = br.readLine();
        String t = br.readLine();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(i + t.length() > s.length()) continue;
            int count = 0;
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i+j) != t.charAt(j)){
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }
        sb.append(ans);
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
