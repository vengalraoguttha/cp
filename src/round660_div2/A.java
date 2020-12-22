package round660_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            /**
             * 2 3 5 7 11
             * 6 10 14 22 15
             * 6 10 14
             * 30
             * 6 10 15
             */
            if(n <= 30){
                sb.append("NO\n");
                continue;
            }

            if(n - 30 != 6 && n - 30 != 10 && n - 30 != 14){
                sb.append("YES\n");
                sb.append("6 10 14 ").append(n - 30).append("\n");
            }else {
                sb.append("YES\n");
                sb.append("6 10 15 ").append(n - 31).append("\n");
            }
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
