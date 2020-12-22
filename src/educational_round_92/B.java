package educational_round_92;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
    private static long calculate(int[] a, int current, int maxLeft, int currentLeft, int l){
        if(currentLeft == maxLeft) return 0;
        if(current - 2*currentLeft < 0) return 0;
        if(current == l) return 0;
        if(current == 0){
            return calculate(a, current + 1, maxLeft, currentLeft,l);
        }
        long val = calculate(a, current + 1, maxLeft, currentLeft,l);
        if(current - 2*currentLeft == 1){
            return Math.max(a[current - 1] - a[current + 1], 0);
        }else {
            return Math.max(a[current - 1] + a[current] - a[current + 1] - a[current + 2], 0);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] arr = nextIntArray(br, 3);
            int[] a = nextIntArray(br, arr[0]);
            long ans = 0;
            for(int i = 0; i < arr[1]; i++){
                ans += a[i];
            }
            sb.append(ans + calculate(a, 0, arr[2], 0, arr[1])).append("\n");
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
