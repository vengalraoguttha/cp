package education_round_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            String s = br.readLine();
            int x = nextInt(br);
            int n = s.length();
            char[] res = new char[s.length()];

            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '0'){
                    if(i - x >= 0){
                        res[i - x] = '0';
                    }
                    if(i + x < n){
                        res[i + x] = '0';
                    }
                }
            }
            boolean found = true;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '1'){
                    boolean can = false;
                    if(i - x >= 0){
                        if(res[i - x] == '\u0000'){
                            can = true;
                        }
                    }
                    if(i + x < n){
                        if(res[i + x] == '\u0000'){
                            can = true;
                        }
                    }
                    if(!can){
                        found = false;
                        break;
                    }
                }
            }
            if(!found){
                sb.append("-1\n");
                continue;
            }
            for(int i = 0; i < n; i++){
                if(res[i] == '\u0000'){
                    sb.append(1);
                }else {
                    sb.append(res[i]);
                }
            }
            sb.append("\n");
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
