package atcoder_bc_177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int h = in[0];
        int w = in[1];
        int start = 0;
        boolean[] blocked = new boolean[w];
        int steps = 0;
        boolean fail = false;
        int[] first = new int[2];
        for(int i = 0; i < h; i++){
            int[] arr = nextIntArray(br, 2);
            if(i == 0) first = arr;
            if(arr[0] - 1 <= start && start <= arr[1] - 1){
                steps += arr[1] - start;
                start = arr[1];
                if(start >= w){
                    fail = true;
                }
            }
            steps++;
            if(fail){
                sb.append("-1\n");
            }else {
                // can start at any better top position
                sb.append(steps).append("\n");
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
