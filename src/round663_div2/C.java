package round663_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    private static long mod = 1000000007;
    private static long pow(long a, long b){
        if( a == 0) return 1;
        if( a == 1) return 1;
        if( b == 1) return a;
        long x = pow(a, b/2);
        if(b % 2 == 0){
            return (x * x) % mod;
        }
        return (x * x * a) % mod;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        long[] fac = new long[n + 1];
        fac[0] = 1;
        fac[1] = 1;
        long mod = 1000000007;
        for(int i = 2; i < n + 1; i++){
            fac[i] = i * fac[i - 1] % mod;
        }
        long ans = 0;
        long[] temps = new long[n + 1];
        for(int i = 2 ; i < n; i++){
            int a = i;
            int b = i + 1;
            int r = n - (i + 1);
            long val = ((2 * (fac[a - 1]) % mod) * fac[r + 1]) % mod;
            temps[i] =  val;
            System.out.println(val);
            ans += temps[i];
            ans %= mod;
        }
        sb.append(ans);
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
