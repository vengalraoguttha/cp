package education_round_94;

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
            String s = br.readLine();
            int[] counts = new int[n];
            for(int i = 0; i < n; i++){
                boolean found = false;
                for(int j = i; j < n + i; j++){
                    if(!found && s.charAt(j) == '1'){
                        counts[j - i]++;
                        found = true;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                if(counts[i] > 0){
                    sb.append(1);
                }else {
                    sb.append(0);
                }
            }
            sb.append("\n");
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
