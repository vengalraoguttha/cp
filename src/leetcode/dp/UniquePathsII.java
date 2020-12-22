package leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePathsII {
    private int[][] dp;
    private int calculate(int i, int j, int[][] obstacleGrid){
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1){
            return 1;
        }
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int x = calculate(i + 1, j, obstacleGrid);
        int y = calculate(i, j + 1, obstacleGrid);
        dp[i][j] = x + y;
        return x + y;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return calculate(0, 0, obstacleGrid);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        UniquePathsII u = new UniquePathsII();
        System.out.println(u.uniquePathsWithObstacles(grid));
    }
}
