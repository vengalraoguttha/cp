package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CAKEDOOM {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = fr.nextInt();
        while (t-- > 0){
            int k = fr.nextInt();
            String s = fr.next();
            if(s.length() == 1){
                if(s.charAt(0) == '?'){
                    sb.append("0\n");
                } else {
                    sb.append(s).append("\n");
                }
                continue;
            }
            if(k == 2 && s.length() % 2 == 1){
                sb.append("NO\n");
                continue;
            }
            if(k == 1 && s.length() >= 2){
                sb.append("NO\n");
                continue;
            }
            boolean no = false;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) != '?' && s.charAt(i) == s.charAt(i - 1)){
                    no = true;
                    break;
                }
            }
            if(s.charAt(0) != '?' && s.charAt(0) == s.charAt(s.length() - 1)){
                no = true;
            }
            if(no){
                sb.append("NO\n");
                continue;
            }
            if(k == 2){
                StringBuilder s1 = new StringBuilder();
                StringBuilder s2 = new StringBuilder();
                for(int i = 0; i < s.length(); i++){
                    if(i % 2 == 0){
                        s1.append(0);
                        s2.append(1);
                    } else {
                        s1.append(1);
                        s2.append(0);
                    }
                }
                boolean f1 = false, f2 = false;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == '?') continue;
                    if(s.charAt(i) != s1.charAt(i)){
                        f1 = true;
                    }
                    if(s.charAt(i) != s2.charAt(i)){
                        f2 = true;
                    }
                }
                if(f1 && f2){
                    sb.append("NO\n");
                    continue;
                }
                if(!f1){
                    sb.append(s1);
                } else {
                    sb.append(s2);
                }
                sb.append("\n");
                continue;
            }
            char[] arr = s.toCharArray();
            boolean check = false;
            char limit = (char) (k + '0');
            for(int i = 0; i < s.length(); i++){
                if(arr[i] != '?') continue;
                if(i > 0 && i < s.length() - 1){
                    char left = arr[i - 1];
                    char right = arr[i + 1];
                    for(int c = 0; c < k; c++){
                        char ch = (char)('0' + c);
                        if(ch != left && ch != right){
                            arr[i] = ch;
                            if(ch >= limit){
                                check = true;
                            }
                            break;
                        }
                    }
                    if(arr[i] == '?') check = true;
                } else if(i == 0){
                    char left = arr[s.length() - 1];
                    char right = arr[i + 1];
                    for(int c = 0; c < k; c++){
                        char ch = (char)('0' + c);
                        if(ch != left && ch != right){
                            arr[i] = ch;
                            if(ch >= limit){
                                check = true;
                            }
                            break;
                        }
                    }
                    if(arr[i] == '?') check = true;
                } else {
                    char left = arr[i - 1];
                    char right = arr[0];
                    for(int c = 0; c < k; c++){
                        char ch = (char)('0' + c);
                        if(ch != left && ch != right){
                            arr[i] = ch;
                            if(ch >= limit){
                                check = true;
                            }
                            break;
                        }
                    }
                    if(arr[i] == '?') check = true;
                }
            }
            if(check){
                sb.append("NO\n");
                continue;
            }
            for(int i = 0; i < arr.length; i++){
                sb.append(arr[i]);
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
