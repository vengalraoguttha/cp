package round667_div3;

import education_dp.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] arr = nextIntArray(br, 5);
            long a = arr[0];
            long b = arr[1];
            long x = arr[2];
            long y = arr[3];
            long n = arr[4];
            long max = Math.min(b - y, n);
            long rem = Math.min(a - x, n - max);

            long max1 = Math.min(a - x, n);
            long rem1 = Math.min(b - y, n - max1);
            sb.append(Math.min((a - max1) * (b - rem1), (a - rem) * (b - max))).append("\n");
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
