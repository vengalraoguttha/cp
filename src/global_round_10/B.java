package global_round_10;

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
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Long.parseLong(st.nextToken());
            }
            long times = k % 2;
            if(times == 0) times = 2;
            long max = Long.MIN_VALUE;
            for(int i = 0; i < n; i++){
                max = Math.max(max, a[i]);
            }

            for(int i = 0; i < times; i++){
                for(int j = 0; j < n; j++){
                    a[j] = max - a[j];
                }

                max = Long.MIN_VALUE;
                for(int j = 0; j < n; j++){
                    max = Math.max(max, a[j]);
                }
            }

            for(int i = 0; i < n; i++){
                sb.append(a[i]).append(" ");
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
