package global_round_10;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        long[][] arr = new long[n][n];
        int current = 1;
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            arr[i][i] = current;
            long val = 1;
            for(int j = i; j < n; j++){
                Random random = new Random();
                val = random.nextInt(Integer.MAX_VALUE);
                arr[i][j] = val * current;
            }
            current++;
            for(int j = i + 1; j < n; j++){
                Random random = new Random();
                val = random.nextInt(Integer.MAX_VALUE);
                arr[j][i] = val * current;
            }
            current++;
        }
//        current = 1;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                arr[i][j] *= current;
//            }
//            current *= 2;
//        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        int q = nextInt(br);

        // find paths

        while (q-- > 0){
            long x = Long.parseLong(br.readLine());
            log.write(paths(arr, 0, 0, x, 0));
        }
    }

    private static String paths(long[][] arr, int x, int y, long sum, long currentSum){
        if(x >= arr.length || y >= arr[0].length) return null;
        currentSum += arr[x][y];
        if(x == arr.length - 1 && y == arr[0].length - 1 && sum == currentSum){
            return (x+1)+" "+(y+1);
        }
        String r1 = paths(arr, x + 1, y, sum, currentSum);
        String r2 = paths(arr, x, y + 1, sum, currentSum);
        if(r1 == null && r2 == null) return null;
        if(r1 != null){
            return (x + 1)+" "+(y + 1)+"\n"+r1;
        }
        return  (x + 1)+" "+(y + 1)+"\n"+r2;
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
