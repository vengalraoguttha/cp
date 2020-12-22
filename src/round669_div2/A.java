package round669_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int[] arr = fr.nextIntArray(n);
            int ones = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] > 0){
                    ones++;
                }
            }
            if(ones <= n/2){
                sb.append(n/2).append("\n");
                for(int i = 0; i < n/2; i++){
                    sb.append("0 ");
                }
                sb.append("\n");
            }else {
                if((n/2) % 2 == 0){
                    sb.append(n/2).append("\n");
                    for(int i = 0; i < n/2; i++){
                        sb.append("1 ");
                    }
                    sb.append("\n");
                }else {
                    sb.append((n/2)+1).append("\n");
                    for(int i = 0; i < (n/2 + 1); i++){
                        sb.append("1 ");
                    }
                    sb.append("\n");
                }
            }
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
