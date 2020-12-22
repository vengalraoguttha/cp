package educational_round_92;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            String s = br.readLine();
            String mid = s.substring(1, s.length() - 1);
            String a = mid + s.charAt(s.length() - 1) + s.charAt(0);
            String b = ""+s.charAt(s.length() - 1) + s.charAt(0) + mid;
            if(a.equals(b)){
                sb.append("0\n");
            }else {
                int[] counts = new int[10];
                for(int i = 0; i < s.length(); i++){
                    counts[s.charAt(i) - '0']++;
                }
                int ans = 0;
                for(int i = 0; i <= 9; i++){
                    for(int j = i + 1; j <= 9; j++){
                        int count = 0;
                        char req = (char) ('0' + i);
                        for(int l = 0; l < s.length(); l++){
                            if(s.charAt(l) == req){
                                count++;
                                if(req == (char) ('0' + i)){
                                    req = (char) ('0' + j);
                                }else {
                                    req = (char) ('0' + i);
                                }
                            }
                        }
                        count -= (count % 2);
                        ans = Math.max(ans, count);
                        count = 0;
                        req = (char) ('0' + j);
                        for(int l = 0; l < s.length(); l++){
                            if(s.charAt(l) == req){
                                count++;
                                if(req == (char) ('0' + i)){
                                    req = (char) ('0' + j);
                                }else {
                                    req = (char) ('0' + i);
                                }
                            }
                        }
                        count -= (count % 2);
                        ans = Math.max(ans, count);
                    }
                }
                for(int i = 0; i < counts.length; i++){
                    ans = Math.max(ans, counts[i]);
                }
                sb.append(s.length() - ans).append("\n");
            }
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
