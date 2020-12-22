package round669_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static int[][] dp;
    private static int ask(int x, int y){
        if(dp[x][y] == -1){
            System.out.println("? "+(x + 1)+" "+(y + 1));
            System.out.flush();
            int res = fr.nextInt();
            dp[x][y] = res;
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        if(n == 1){
            System.out.println("! 1");
            System.out.flush();
        }
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        while (true){
            boolean a = false;
            for(int i = 1; i < n; i++){
                int res = ask(i - 1, i);
                int exp = n % res;
                StringBuilder ss = new StringBuilder();
                boolean check = n > 2;
                int cc = -1;
                int ccs = -1;
                if(check){
                    cc = ask(n - 1, i);
                    ccs = n % cc;
                    check = (ccs == ask(i, n - 1));
                }
                if(exp == ask(i, i - 1) && ((n <= 2) || check)){
                    ss.append("! ");
                    for(int j = 0; j < n; j++){
                        if(j == i){
                            ss.append(n+" ");
                            continue;
                        }
                        ss.append(ask(j, i)+" ");
                    }
                    System.out.println(ss.toString());
                    System.out.flush();
                    a = true;
                    break;
                }
                if(a) break;;
            }
            if(a) break;
        }
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
