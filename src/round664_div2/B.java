package round664_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] a = nextIntArray(br, 4);
        int n = a[0];
        int m = a[1];
        int x = a[2];
        int y = a[3];
        sb.append(x).append(" ").append(y).append("\n");
        int col;
        if(y != m){
            for(col = 1; col <= m; col++){
                if(col == y) continue;
                sb.append(x).append(" ").append(col).append("\n");
            }
            col = m;
        }else {
            for(col = m; col >= 1; col--){
                if(col == y) continue;
                sb.append(x).append(" ").append(col).append("\n");
            }
            col = 1;
        }
        // go top
        int row = x - 1;
        while (row >= 1){
            if(col > 1){
                while (col >= 1){
                    sb.append(row).append(" ").append(col).append("\n");
                    col--;
                }
                col = 1;
            }else {
                while (col <= m){
                    sb.append(row).append(" ").append(col).append("\n");
                    col++;
                }
                col = m;
            }
            row--;
        }
        // go bottom
        row = x + 1;
        while (row <= n){
            if(col > 1){
                while (col >= 1){
                    sb.append(row).append(" ").append(col).append("\n");
                    col--;
                }
                col = 1;
            }else {
                while (col <= m){
                    sb.append(row).append(" ").append(col).append("\n");
                    col++;
                }
                col = m;
            }
            row++;
        }
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
