package atcoder_bc_178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class F {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int[] a = fr.nextIntArray(n);
        int[] b = fr.nextIntArray(n);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            map.put(b[i], map.getOrDefault(b[i], 0) + 1);
        }
        int[] c = new int[n];
        for(int i = 0; i < n; i++){
            if(a[i] != map.firstKey()){
                int first = map.firstKey();
                c[i] = first;
                int val = map.get(first);
                if(val == 1) map.remove(first);
                else map.put(first, val - 1);
            } else if(map.lastKey() != a[i]){
                int last = map.lastKey();
                c[i] = last;
                int val = map.get(last);
                if(val == 1) map.remove(last);
                else map.put(last, val - 1);
            } else if(map.keySet().size() == 1){
                System.out.println("No");
                return;
            } else {
                for(int key : map.keySet()){
                    if(key != a[i]){
                        c[i] = key;
                        int val = map.get(key);
                        if(val == 1) map.remove(key);
                        else map.put(key, val - 1);
                    }
                }
            }
        }

        sb.append("Yes\n");
        for(int i = 0; i < n; i++){
            sb.append(c[i]).append(" ");
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
