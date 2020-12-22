package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TACHSTCK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 2);
        int n = in[0];
        int d = in[1];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = nextInt(br);
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] - arr[i - 1] <= d){
                count++;
                i++;
            }
        }
        sb.append(count);
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
