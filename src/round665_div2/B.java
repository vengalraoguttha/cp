package round665_div2;

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
            int[] in1 = nextIntArray(br, 3);
            int[] in2 = nextIntArray(br, 3);
            long ans = 0;
            long m1 = Math.min(in1[2], in2[1]);
            ans += 2*m1;
            in1[2] -= m1;
            in2[1] -= m1;
            if(in2[2] - in1[2] > 0  && in2[2] - in1[2] > in1[0]){
                long rem = in2[2] - in1[2] - in1[0];
                ans -= 2*rem;
            }
            sb.append(ans).append("\n");

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

