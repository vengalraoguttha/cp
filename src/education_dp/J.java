package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J {

    private static double[][][] dp;
    private static double calculate(int one, int two, int three, long len){
        double total = one + two + three;
        if(total == 0) {
            dp[one][two][three] = 0;
            return dp[one][two][three];
        }
        if(dp[one][two][three] != -1) return dp[one][two][three];
        double l = len*1.0/total;
        double ans = 0;
        if(one > 0){
            ans += (calculate(one - 1, two, three, len) + l)*(one/total);
        }
        if(two > 0){
            ans += (calculate(one + 1, two - 1, three, len) + l)*(two/total);
        }
        if(three > 0){
            ans += (calculate(one, two + 1, three - 1, len) + l)*(three/total);
        }
        dp[one][two][three] = ans;
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        int one = 0, two = 0, three = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 1) one++;
            if(arr[i] == 2) two++;
            if(arr[i] == 3) three++;
            max += arr[i];
        }

        dp = new double[n + 1][n + 1][n + 1];

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        sb.append(calculate(one, two, three, n));
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
