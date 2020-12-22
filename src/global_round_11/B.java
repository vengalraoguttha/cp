package global_round_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int n = fr.nextInt();
            int k = fr.nextInt();
            String s = fr.next();

            if(n == 1){
                int res = 0;
                if(s.charAt(0) == 'W'){
                    res++;
                }
                if(res == 1){
                    sb.append(res).append("\n");
                    continue;
                }
                if(k > 0){
                    sb.append("1\n");
                    continue;
                }
                sb.append(res).append("\n");
                continue;
            }

            List<Integer> wins = new ArrayList<>();
            int prev = -1;
            long result = 0;
            int l = 0;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == 'L') l++;
                if(s.charAt(i) == 'W'){
                    if( i ==  0){
                        result++;
                    } else {
                        if(s.charAt(i - 1) == 'L') result++;
                        else result += 2;
                    }
                }
                if(s.charAt(i) == 'W'){
                    if(prev == -1){
                        wins.add(i);
                    } else {
                        if(prev != i - 1){
                            wins.add(i);
                        }
                    }
                    prev = i;
                } else {
                    if(prev != -1){
                        wins.add(prev);
                        prev = -1;
                    }
                }
            }
            if(l == n){
                if(k == 0){
                    sb.append("0\n");
                    continue;
                }
                sb.append((2*Math.min(n, k) - 1)).append("\n");
                continue;
            }
            wins.add(n);
            List<Pair<Integer, Integer>> lens = new ArrayList<>();
            lens.add(new Pair<Integer, Integer>(wins.get(0), 0));
            for(int i = 1; i < wins.size(); i++){
                if(i % 2 == 1) continue;
                if(wins.get(i) - wins.get(i - 1) - 1 < 0) continue;
                if(i != wins.size() - 1)
                lens.add(new Pair<>(wins.get(i) - wins.get(i - 1) - 1, 1));
                else lens.add(new Pair<>(wins.get(i) - wins.get(i - 1) - 1, 0));
            }
            lens.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    if(!o1.second.equals(o2.second))
                    return o2.second - o1.second;
                    else return o1.first - o2.first;
                }
            });
            for(int i = 0; i < lens.size(); i++){
                if(k == 0) break;
                int x = Math.min(k, lens.get(i).first);
                if(x == 0) continue;
                k -= x;
                if(x == lens.get(i).first && lens.get(i).second == 1){
                    result += (x * 2) + 1;
                } else {
                    result += (x * 2);
                }
            }
            sb.append(result).append("\n");
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

    static long mod(String num, long a)
    {
        // Initialize result
        long res = 0;

        // One by one process all digits of 'num'
        for (int i = 0; i < num.length(); i++)
            res = (res*10 +  num.charAt(i) - '0') %a;

        return res;
    }

    static long binomialCoeff(long n, long k, long MOD)
    {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of
        // [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
            res %= MOD;
        }

        return res;
    }

    static long power(long x, long y, long p)
    {

        // Initialize result
        long res = 1;

        // Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x
            // with result
            if (y % 2 == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }

    // Returns n^(-1) mod p
    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }

    // Returns nCr % p using Fermat's
    // little theorem.
    static long nCrModPFermat(int n, int r,
                              long p)
    {

        // Base case
        if (r == 0)
            return 1;

        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        long[] fac = new long[n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[n] * modInverse(fac[r], p)
                % p * modInverse(fac[n - r], p)
                % p)
                % p;
    }
}
