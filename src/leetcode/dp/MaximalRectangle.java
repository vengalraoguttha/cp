package leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalRectangle {
    private int[][] dp;
    private int calculate(int i, int j, char[][] matrix){
        int len = 0;
        for(int l = j; l >= 0; l--){
            if(matrix[i][l] == '1') len++;
            else break;
        }
        dp[i][j] = len;
        int height = len;
        int area = len;
        for(int l = i - 1; l >= 0; l--){
            if(matrix[l][j] == '1'){
                int width = i - l + 1;
                height = Math.min(height, dp[l][j]);
                area = Math.max(area, width*height);
            } else {
                break;
            }
        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int area = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                area = Math.max(area, calculate(i, j, matrix));
            }
        }
        return area;
    }

    class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next().toCharArray();
        }
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(arr));
    }
}
