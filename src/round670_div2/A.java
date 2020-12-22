package round670_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(fr.nextInt());
            }
            list.sort(null);
            int current = 0;
            int[] counts = new int[101];
            for(int i = 0; i < n; i++){
                if(i == 0){
                    if(current != list.get(i)) break;
                }
                if(current + 1 == list.get(i)){
                    current++;
                    counts[current]++;
                } else if(current == list.get(i)){
                    counts[current]++;
                } else {
                    break;
                }
            }
            int ans = 0;
            for(int i = 0; i < 101; i++){
                if(counts[i] > 1){
                    ans++;
                } else {
                    break;
                }
            }
            for(int i = 0; i < 101; i++){
                if(counts[i] > 0) ans++;
            }

            sb.append(ans).append("\n");
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
