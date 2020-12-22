package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K implements Runnable {
    private static Boolean[][] dp;
    private static boolean calculate(int player, int stones, int[] arr){
        if(stones < 0){
            if(player == 0){
                return true;
            }
            return false;
        }
        if(stones == 0){
            if(player == 0) return false;
            return true;
        }
        if(dp[player][stones] != null) return dp[player][stones];
        if(player == 0){
            boolean res = false;
            for(int i = 0; i < arr.length; i++){
                res = res || calculate(1, stones - arr[i], arr);
            }
            dp[player][stones] = res;
            return res;
        } else {
            boolean res = true;
            for(int i = 0; i < arr.length; i++){
                res = res & calculate(0, stones - arr[i], arr);
            }
            dp[player][stones] = res;
            return res;
        }
    }
    public static void main(String[] args) {
        new Thread(null, new K(), "Main", 1<<26).start();
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

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = new int[0];
        try {
            in = nextIntArray(br, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n = in[0];
        int k = in[1];
        int[] arr = new int[0];
        try {
            arr = nextIntArray(br, n);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dp = new Boolean[2][k + 1];
        if(calculate(0, k, arr))
            sb.append("First");
        else sb.append("Second");
        System.out.print(sb.toString());
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
