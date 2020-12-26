package leetcode_weekly_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    static class Node{
        String current;
        Map<String, Double> next;
    }

    HashMap<String, Node> nodes = new HashMap<>();

    private double dfs(String from, String till, Set<String> visited){
        visited.add(from);
        Node fromNode = nodes.get(from);
        if(nodes.containsKey(from) && from.equals(till)) return 1.0;
        double res = -1;
        if(fromNode != null && fromNode.next != null){
            for(Map.Entry<String, Double> entry : fromNode.next.entrySet()){
                if(!visited.contains(entry.getKey())){
                    double val = dfs(entry.getKey(), till, visited);
                    if(val != -1) res = val * entry.getValue();
                }
            }
        }

        return res;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String till = equation.get(1);
            Node fromNode = nodes.getOrDefault(from, new Node());
            fromNode.current = from;
            if(fromNode.next == null) fromNode.next = new HashMap<>();
            fromNode.next.put(till, values[i]);
            nodes.put(from, fromNode);

            Node tillNode = nodes.getOrDefault(till, new Node());
            tillNode.current = till;
            if(tillNode.next == null) tillNode.next = new HashMap<>();
            tillNode.next.put(from, 1/values[i]);
            nodes.put(till, tillNode);
        }

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String from = query.get(0);
            String till = query.get(1);
            ans[i] = dfs(from, till, new HashSet<>());
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int q = fr.nextInt();
        List<List<String>> eq = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<String> l = new ArrayList<>();
            l.add(fr.next());
            l.add(fr.next());
            eq.add(l);
        }
        double[] val = new double[n];
        for(int i = 0; i < n; i++){
            val[i] = fr.nextInt();
        }

        List<List<String>> qer = new ArrayList<>();
        for(int i = 0; i < q; i++){
            List<String> l = new ArrayList<>();
            l.add(fr.next());
            l.add(fr.next());
            qer.add(l);
        }

        D d = new D();
        double[] res = d.calcEquation(eq, val, qer);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
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
