package kickstart2020_round_D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    private static int[][] dp;
    private static int calculate(int current, int previousNote, int[] arr){
        if(current == arr.length) return 0;
        if(dp[current][previousNote] != -1) return dp[current][previousNote];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 4; i++){
            if(arr[current] > arr[current - 1]){
                if(i > previousNote){
                    min = Math.min(calculate(current + 1, i, arr), min);
                }else {
                    min = Math.min(1 + calculate(current + 1, i, arr), min);
                }
            }else if(arr[current] < arr[current - 1]){
                if(i < previousNote){
                    min = Math.min(calculate(current + 1, i, arr), min);
                }else{
                    min = Math.min(1 + calculate(current + 1, i, arr), min);
                }
            }else {
                if(i == previousNote){
                    min = Math.min(calculate(current + 1, i, arr), min);
                }else {
                    min = Math.min(1 + calculate(current + 1, i, arr), min);
                }
            }
        }
        dp[current][previousNote] = min;
        return min;
    }
    private static int solve(BufferedReader br) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[k+1][5];
        for(int i = 0; i < k + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer min = Integer.MAX_VALUE;
        for(int i = 1; i <= 4; i++){
            min = Math.min(calculate(1, i, arr), min);
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= t; i++){
            sb.append("Case #").append(i).append(": ").append(solve(br)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
