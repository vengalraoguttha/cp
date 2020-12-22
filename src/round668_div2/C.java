package round668_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int k = fr.nextInt();
            StringBuilder s = new StringBuilder(fr.next());
            int ones = 0;
            int zeros = 0;
            int q_ones = 0, q_zeros = 0;
            for(int i = 0; i < k; i++){
                if(s.charAt(i) == '1') ones++;
                else if(s.charAt(i) == '0') zeros++;
            }
            int qs = k - ones - zeros;
            if(ones > k/2 || zeros > k/2){
                sb.append("NO\n");
                continue;
            }
            q_ones = k/2 - ones;
            q_zeros = k/2 - zeros;

            boolean check = false;
            for(int i = k; i < n; i++){
                if(s.charAt(i) == '?'){
                    if(s.charAt(i - k) == '1'){
                        s.setCharAt(i, '1');
                    } else if(s.charAt(i - k) == '0'){
                        s.setCharAt(i, '0');
                    } else {

                    }
                } else if(s.charAt(i) == '1'){
                    if(s.charAt(i - k) == '1'){
                    } else if(s.charAt(i - k) == '0'){
                        check = true;
                        sb.append("NO\n");
                        break;
                    } else {
                        if(q_ones == 0){
                            check = true;
                            sb.append("NO\n");
                            break;
                        }
                        q_ones--;
                    }
                } else {
                    if(s.charAt(i - k) == '1'){
                        check = true;
                        sb.append("NO\n");
                        break;
                    } else if(s.charAt(i - k) == '0'){
                    } else {
                        if(q_zeros == 0){
                            check = true;
                            sb.append("NO\n");
                            break;
                        }
                        q_zeros--;
                    }
                }
            }

            if(check){
                continue;
            }
            sb.append("YES\n");
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
