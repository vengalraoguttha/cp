package education_round_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] in1 = nextIntArray(br, 2);
            int p = in1[0];
            int f = in1[1];
            int[] in2 = nextIntArray(br, 2);
            int cnts = in2[0];
            int cntw = in2[1];
            int[] in3 = nextIntArray(br, 2);
            int s = in3[0];
            int w = in3[1];
            int minw = -1;
            int c = -1;
            int maxw = -1;
            int d = -1;
            if(s < w){
                minw = s;
                c = cnts;
                d = cntw;
                maxw = w;
            }else {
                minw = w;
                c = cntw;
                d = cnts;
                maxw = s;
            }
            int maxX = p/minw;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i <= Math.min(maxX, c); i++){
                int r = c - i;
                r = Math.min(r, f/minw);
                int xr = p - (i * minw);
                int yr = f - (r * minw);
                int ax = Math.min(xr/maxw, d);
                int ay = Math.min(yr/maxw, d - ax);
                max = Math.max(max, i + r + ax + ay);
            }
            sb.append(max).append("\n");
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
