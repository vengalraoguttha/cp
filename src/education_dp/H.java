package education_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
    private static long MOD =  1000000007;
    private static long[][] dp;
    private static long calculate(int x, int y, char[][] grid){
        if(x == grid.length - 1 && y == grid[0].length - 1) return 1;
        if(x >= grid.length || y >= grid[0].length) return 0;
        if(grid[x][y] == '#') return 0;
        if(dp[x][y] != -1) return dp[x][y];
        long a = calculate(x + 1, y, grid) % MOD;
        long b = calculate(x, y + 1, grid) % MOD;
        dp[x][y] = (a + b) % MOD;
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int h = in[0];
        int w = in[1];
        char[][] grid = new char[h][w];
        dp = new long[h][w];
        for(int i = 0; i < h; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < h; i++){
            grid[i] = br.readLine().toCharArray();
        }
        sb.append(calculate(0, 0, grid));
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
