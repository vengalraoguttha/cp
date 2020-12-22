package atcoder_bc_175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
    static long[][][] dp;
    private static long calculate(int x, int y, int R, int C, int[][] grid, int[] rowCounts){
        if(x < 0 || y < 0 || x >= R || y >= C) return -1;
        if(dp[x][y][rowCounts[x]] != -1) return dp[x][y][rowCounts[x]];
        if(x == R - 1 && y == C - 1){
            if(rowCounts[x] == 3 || grid[x][y] == 0){
                dp[x][y][rowCounts[x]] = 0;
                return 0;
            }
            dp[x][y][rowCounts[x]] = grid[x][y];
            return grid[x][y];
        }
        if(rowCounts[x] == 3 || grid[x][y] == 0){
            long a = calculate(x + 1, y, R, C, grid, rowCounts);
            long b = calculate(x, y + 1, R, C, grid, rowCounts);
            if(a == - 1 && b == -1) {
                dp[x][y][rowCounts[x]] = -1;
                return -1;
            }
            dp[x][y][rowCounts[x]] = Math.max(a, b);
            return Math.max(a, b);
        }else {
            long a = calculate(x + 1, y, R, C, grid, rowCounts);
            long b = calculate(x, y + 1, R, C, grid, rowCounts);
            rowCounts[x]++;
            long c = calculate(x + 1, y, R, C, grid, rowCounts);
            long d = calculate(x, y + 1, R, C, grid, rowCounts);
            if(a == - 1 && b == -1 && c == -1 && d == -1) return -1;
            rowCounts[x]--;
            long l1 = Math.max(a, b);
            long l2 = grid[x][y] + Math.max(c, d);
            if(l1 > l2){
                dp[x][y][rowCounts[x]] = l1;
                return l1;
            }
            dp[x][y][rowCounts[x]] = l2;
            return l2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 3);
        int R = in[0];
        int C = in[1];
        int K = in[2];

        int[][] vals = new int[K][3];
        int[][] grid = new int[R][C];
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            vals[i][0] = Integer.parseInt(st.nextToken());
            vals[i][1] = Integer.parseInt(st.nextToken());
            vals[i][2] = Integer.parseInt(st.nextToken());
            grid[vals[i][0] - 1][vals[i][1] - 1] = vals[i][2];
        }
        int[] rowCounts = new int[R];
        dp = new long[R][C][4];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        sb.append(calculate(0, 0, R, C, grid, rowCounts));
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
