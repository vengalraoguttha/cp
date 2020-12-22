package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class L {
    private static Long[][][] dp;
    private static long calculate(int player, int left, int right, int[] arr){
        if(left > right) return 0;
        if(dp[player][left][right] != null) return dp[player][left][right];
        if(player == 0){
            long x = arr[left] + calculate(1, left + 1, right, arr);
            long y = arr[right] + calculate(1, left, right - 1, arr);
            dp[player][left][right] = Math.max(x, y);
            return Math.max(x, y);
        }else {
            long x = -arr[left] + calculate(0, left + 1, right, arr);
            long y = -arr[right] + calculate(0, left, right - 1, arr);
            dp[player][left][right] = Math.min(x, y);
            return Math.min(x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        dp = new Long[2][n][n];
        sb.append(calculate(0, 0, n - 1, arr));
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
