package round657_div2;

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            long vv = Long.parseLong(st.nextToken());
            int max = arr[1] - arr[0];
            long mh = vv + (max);
            long ml = vv - (max);
            int s = arr[0];
            for(long i = vv - max; i <= vv + max; i++){
                if(i % s != 0 || i <= 0) continue;
                if(i - vv < 0){
                    sb.append(arr[0]).append(" ").append(arr[1]).append(" ").append(arr[1] + (i - vv)).append("\n");
                }else {
                    sb.append(arr[0]).append(" ").append(arr[0]).append(" ").append(arr[0] + (i - vv)).append("\n");
                }
                break;
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
