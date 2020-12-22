package kickstart_round_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        int test = 1;
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            int len = 2;
            int maxLen = 0;
            int diff = 0;
            for(int i = 1; i < n; i++){
                if(i == 1){
                    diff = arr[i] - arr[i - 1];
                    maxLen = Math.max(len, maxLen);
                }else {
                    if(arr[i] - arr[i - 1] != diff){
                        len = 2;
                        diff = arr[i] - arr[i - 1];
                        maxLen = Math.max(len, maxLen);
                    }else {
                        len++;
                        maxLen = Math.max(len, maxLen);
                    }
                }
            }
            sb.append("Case #"+test+": "+maxLen).append("\n");
            test++;
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
