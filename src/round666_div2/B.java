package round666_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        Arrays.sort(arr);
        long ans = Long.MAX_VALUE;
        int MAX = arr[n - 1];
        //System.out.println(MAX);
//        int start = 1;
////        int end = MAX;
////        while (start <= end){
////            int c = start + (end - start)/2;
////
////        }
        for(int c = 1; c <= MAX; c++){
            long val = 1;
            long temp = 0;
            for(int i = 0; i < n; i++){
                temp += Math.abs(val - arr[i]);
                val *= c;
                if(val < 0) break;
            }
            if(temp < 0) break;
            ans = Math.min(ans, temp);
            if(temp > ans){
                break;
            }
        }
        sb.append(ans);
        System.out.print(sb.toString());
    }

    private static long pow(long a, long b){
        if(b == 0) return 1;
        if(a == 1) return 1;
        if(b == 1) return a;
        long val = pow(a, b/2);
        if(b % 2 == 0){
            return val*val;
        }else {
            return val*val*a;
        }
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
