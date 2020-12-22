package round669_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static int gcd(int a, int b){
        if(a < b) return gcd(b, a);
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int[] arr = fr.nextIntArray(n);
            int max = 0;
            int maxIndex = -1;
            for(int i = 0; i < n; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxIndex = i;
                }
            }
            sb.append(max).append(" ");
            boolean[] used = new boolean[n];
            used[maxIndex] = true;
            int now = max;
            for(int i = 0; i < n - 1; i++){
                int maxGcd = -1;
                int maxInd = -1;
                int currentMax = -1;
                for(int j = 0; j < n; j++){
                    if(!used[j]){
                        int gcd = gcd(now, arr[j]);
                        if(maxGcd < gcd){
                            currentMax = arr[j];
                            maxInd = j;
                            maxGcd = gcd;
                        } else if(maxGcd == gcd){
                            if(currentMax < arr[j]){
                                currentMax = arr[j];
                                maxInd = j;
                            }
                        }
                    }
                }
                used[maxInd] = true;
                now = gcd(now, currentMax);
                sb.append(currentMax).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static class FastReader{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
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
