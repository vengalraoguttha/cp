package round665_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);

        }
        System.out.print(sb.toString());
    }

    private static int gcd(int a, int b){
        if(a < b) return gcd(b, a);
        if(a % b == 0) return b;
        return gcd(b, a % b);
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

