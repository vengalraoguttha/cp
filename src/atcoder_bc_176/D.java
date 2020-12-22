package atcoder_bc_176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    private static long[][] dp;
    private static long calculate(String[] grid, int x, int y, int dx, int dy, boolean[][] visited){
        if(x == dx && y == dy) return 0;
        else if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length()) return -1;
        visited[x][y] = true;
        if(dp[x][y] != -2){
            visited[x][y] = false;
            return dp[x][y];
        }
        if(grid[x].charAt(y) == '.'){
            long ans = -1;
            {
                long v1 = -1;
                if(x + 1 < grid.length){
                    v1 = visited[x + 1][y] ? - 1 : calculate(grid, x + 1, y, dx, dy, visited);
                }
                long v2 = -1;
                if(y + 1 < grid[0].length()){
                    v2 = visited[x][y + 1] ? -1 : calculate(grid, x, y + 1, dx, dy, visited);
                }
                if(v1 != -1 && v2 != -1){
                    ans = Math.min(v1, v2);
                }else if(v1 != -1){
                    ans = v1;
                }else if(v2 != -1){
                    ans = v2;
                }
            }
            long a1 = ans;
            long a2 = Long.MAX_VALUE;
            ans = Long.MAX_VALUE;
            {
                for(int i = x - 2; i <= x + 2; i++){
                    for(int j = y - 2; j <= y + 2; j++){
                        if(i == x && j == y + 1) continue;
                        if(i == x + 1 && j == y) continue;
                        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length()) continue;
                        if(grid[i].charAt(j) == '#') continue;
                        long v = visited[i][j] ? -1 : calculate(grid, i, j, dx, dy, visited);
                        if(v != -1){
                            ans = Math.min(ans, v);
                        }
                    }
                }
                if(ans != Long.MAX_VALUE){
                    a2 = ans + 1;
                }else {
                    a2 = -1;
                }
            }
            if(a1 != -1 && a2 != -1){
                dp[x][y] = Math.min(a1, a2);
            }else if(a1 != -1){
                dp[x][y] = a1;
            }else {
                dp[x][y] = a2;
            }
            visited[x][y] = false;
            return dp[x][y];
        }else {
            visited[x][y] = false;
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] hw = nextIntArray(br, 2);
        int[] c = nextIntArray(br, 2);
        int[] d = nextIntArray(br, 2);
        String[] grid = new String[hw[0]];
        for(int i = 0; i < hw[0]; i++){
            grid[i] = br.readLine();
        }
        if(grid[d[0] - 1].charAt(d[1] - 1) == '#' || grid[c[0] - 1].charAt(c[1] - 1) == '#'){
            sb.append(-1);
            System.out.println(sb);
            return;
        }
        dp = new long[grid.length][grid[0].length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -2);
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        sb.append(calculate(grid, c[0] - 1, c[1] - 1, d[0] - 1, d[1] - 1, visited));
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
