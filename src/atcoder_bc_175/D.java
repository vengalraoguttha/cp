package atcoder_bc_175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int n = in[0];
        long k = in[1];
        int[] p = nextIntArray(br, n);
        int[] c = nextIntArray(br, n);

        int[][] vals = new int[n][n];
        int[] limits = new int[n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            int next = p[i];
            boolean s = false;
            for(int j = 0; j < n; j++){
                visited[i][next - 1] = true;
                vals[i][j] = c[next - 1];
                next = p[next - 1];
                if(visited[i][next - 1]){
                    limits[i] = j + 1;
                    s = true;
                    break;
                }
            }

            if(!s){
                limits[i] = n + 1;
            }
        }

        long totalMax = Long.MIN_VALUE;
        for(int i = 0; i < n; i++){
            long acc = 0;
            for(int j = 0; j < Math.min(limits[i], k); j++){
                acc += vals[i][j];
                totalMax = Math.max(totalMax, acc);
            }
            if(limits[i] >= k){
                continue;
            }

            long rem = 0;
            if(k%limits[i] > 0){
                acc = (k/limits[i])*acc;
                totalMax = Math.max(totalMax, acc);
                rem = k % limits[i];
            }else {
                acc = (k/limits[i] - 1)*acc;
                totalMax = Math.max(totalMax, acc);
                rem = limits[i];
            }
            for(int j = 0; j < rem; j++){
                acc += vals[i][j];
                totalMax = Math.max(totalMax, acc);
            }
        }
        sb.append(totalMax);
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
