package round666_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    static void swap(int x, int y)
    {
        int temp = x;
        x = y;
        y = temp;
    }
    static int smallestCommon(int a, int b,
                              int c, int d)
    {
        // If a is equal to c
        if (a == c)
            return a;

        // If a exceeds c
        if (a > c)
        {
            swap(a, c);
            swap(b, d);
        }

        int first_term_diff = (c - a);
        int possible_y;

        // Check for the satisfying
        // equation
        for (possible_y = 0;
             possible_y < b; possible_y++)
        {

            // Least value of possible_y
            // satisfying the given equation
            // will yield true in the below if
            // and break the loop
            if ((first_term_diff % b +
                    possible_y * d) % b == 0)
            {
                break;
            }
        }

        // If the value of possible_y
        // satisfying the given equation
        // lies in range [0, b]
        if (possible_y != b)
        {
            return c + possible_y * d;
        }

        // If no value of possible_y
        // satisfies the given equation
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        if(n == 1){
            sb.append("1 1\n");
            sb.append(arr[0]).append("\n");
            sb.append("1 1\n");
            sb.append(arr[0]).append("\n");
            sb.append("1 1\n");
            sb.append(-3*arr[0]).append("\n");
            System.out.println(sb.toString());
            return;
        }
        long[] vals = new long[n];
        sb.append(1).append(" ").append(1).append("\n");
        for(int i = 0; i < 1; i++){
            sb.append(n - arr[i]).append(" ");
            vals[i] = n;
        }
        sb.append("\n");
        sb.append(2).append(" ").append(n).append("\n");

        for(int i = 1; i < n; i++){
            long val = arr[i] + (n - 1)*n;
            while (true){
                if(val % n == 0) break;
                val += n - 1;
            }
            vals[i] = val;
            sb.append(vals[i] - arr[i]).append(" ");
        }
        sb.append("\n");
        sb.append(1).append(" ").append(n).append("\n");
        for(int i = 0; i < n; i++){
            sb.append(-vals[i]).append(" ");
        }
        sb.append("\n");
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
