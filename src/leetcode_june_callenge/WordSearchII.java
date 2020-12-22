package leetcode_june_callenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSearchII {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean valid(int x, int y, char[][] board){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        return true;
    }
    private boolean dfs(String word, char[][] board, int current, int i, int j, boolean[][] visited){
        if(current == word.length() - 1) return true;
        visited[i][j] = true;
        boolean ans = false;
        for(int[] direction : directions){
            if(valid(i + direction[0], j + direction[1], board)){
                if(board[i + direction[0]][j + direction[1]] == word.charAt(current + 1) && !visited[i + direction[0]][j + direction[1]]){
                    ans = ans || dfs(word, board, current + 1, i + direction[0], j + direction[1], visited);
                }
            }
        }
        visited[i][j] = false;
        return ans;
    }
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || board[0].length == 0) return new ArrayList<>();
        List<Pair<Integer, Integer>>[] starts = new ArrayList[26];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(starts[board[i][j] - 'a'] == null){
                    starts[board[i][j] - 'a'] = new ArrayList<>();
                }
                starts[board[i][j] - 'a'].add(new Pair<>(i, j));
            }
        }

        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(String word : words){
            if(starts[word.charAt(0) - 'a'] == null || starts[word.charAt(0) - 'a'].size() == 0) continue;
            for(Pair<Integer, Integer> pair : starts[word.charAt(0) - 'a']){
                for(int i = 0; i < board.length; i++){
                    Arrays.fill(visited[i], false);
                }
                if(dfs(word, board, 0, pair.first, pair.second, visited)){
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }

    class Pair<A, B>{
        A first;
        B second;
        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = new String[]{"eaabcdgfa"};
        WordSearchII w = new WordSearchII();
        System.out.println(w.findWords(b, words));
    }
}
