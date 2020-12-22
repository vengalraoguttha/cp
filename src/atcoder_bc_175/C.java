package atcoder_bc_175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());
        X = Math.abs(X);
        long maxSteps = (X - X%D)/D;
        if(maxSteps >= K){
            sb.append(X - K*D);
        }else {
            long rem = K - maxSteps;
            if(rem % 2 == 1){
                sb.append(Math.abs( (X % D) - D ));
            }else {
                sb.append(X % D);
            }
//            if(X % D > Math.abs( (X % D) - D )){
//                if(rem % 2 == 1){
//                    sb.append(Math.abs( (X % D) - D ));
//                }else {
//                    sb.append(X % D);
//                }
//            }else {
//                if(rem % 2 == 1){
//                    sb.append(Math.abs( (X % D) - D ));
//                }else {
//                    sb.append(X % D);
//                }
//            }
            //sb.append(Math.min(X % D, Math.abs( (X % D) - D )));
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
