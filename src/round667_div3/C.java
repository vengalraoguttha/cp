package round667_div3;

import sun.nio.cs.ext.MacArabic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] in = nextIntArray(br, 3);
            int n = in[0];
            int x = in[1];
            int y = in[2];
            if(n == 2){
                sb.append(x).append(" ").append(y).append("\n");
                continue;
            }
            int val = Math.abs(x - y);
            long ans = Long.MAX_VALUE;
            for(int i = 1; i < n; i++){
                if(val % i != 0) continue;
                int min = Math.min(x, y);
                int diff = val/i;
                int used = Math.abs(x - y)/diff + 1;
                int rem = n - used;
                int vv = (min % diff == 0) ? min/diff - 1 : min/diff;
                int temp = Math.min(Math.max(vv, 0), rem);
                int rem2 = n - used - temp;
                int xx = Math.max(x, y) + rem2*diff;
                ans = Math.min(ans, xx);
            }

            for(int i = 1; i < n; i++){
                if(val % i != 0) continue;
                int min = Math.min(x, y);
                int diff = val/i;
                int used = Math.abs(x - y)/diff + 1;
                int rem = n - used;
                int vv = (min % diff == 0) ? min/diff - 1 : min/diff;
                int temp = Math.min(Math.max(vv, 0), rem);
                int rem2 = n - used - temp;
                int now = Math.max(x, y) + rem2*diff;
                if(now == ans){
                    int start = Math.min(x, y) - temp*diff;
                    for(int j = 0; j < n; j++){
                        sb.append(start).append(" ");
                        start += diff;
                    }
                    sb.append("\n");
                    break;
                }
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
