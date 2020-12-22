package round662_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    private static int[][] directions = new int[][]{{0, -1}, {-1, 0}};
    private static int[][] dp;
    private static boolean isValid(int x, int y, String[] s){
        if(x < 0 || y < 0 || x >= s.length || y >= s[0].length()) return false;
        return true;
    }

    private static int dfs(String[] s, boolean[][] visited, int i, int j){
        if(dp[i][j] != -1) {
            visited[i][j] = false;
            return dp[i][j];
        }
        visited[i][j] = true;
        int count = 1;
        boolean valid = true;
        for(int[] direction : directions){
            if(!isValid(i + direction[0], j + direction[1], s)
                    || !(s[i].charAt(j) == s[i + direction[0]].charAt(j + direction[1]))){
                valid = false;
                break;
            }
        }
        if(!valid) {
            dp[i][j] = count;
            visited[i][j] = false;
            return count;
        }
        int min = Integer.MAX_VALUE;
        for(int[] direction : directions){
            if(isValid(i + direction[0], j + direction[1], s) && (s[i].charAt(j) == s[i + direction[0]].charAt(j + direction[1]))){
                visited[i + direction[0]][j + direction[1]] = true;
                min = Math.min(min, dfs(s, visited, i + direction[0], j + direction[1]));
            }
        }
        dp[i][j] = count + min;
        visited[i][j] = false;
        return count + min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        String in = br.readLine();
        int n = Integer.parseInt(in.split(" ")[0]);
        int m = Integer.parseInt(in.split(" ")[1]);
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = br.readLine();
        }
        boolean[][] visited = new boolean[n][m];
        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                count += dfs(s, visited, i, j);
            }
        }

        sb.append(count).append("\n");

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
