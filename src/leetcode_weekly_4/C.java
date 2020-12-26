package leetcode_weekly_4;

import education_dp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    static class Solution {

        List<Pair<Integer, Integer>> pairs;
        Random random;
        public Solution(int[] nums) {
            pairs = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                pairs.add(new Pair<>(nums[i], i));
            }

            pairs.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    if(o1.first.equals(o2.first)) return 0;
                    if(o1.first > o2.first) return 1;
                    else return -1;
                }
            });
            random = new Random();
        }

        public int pick(int target) {
            int lo = 0, hi = pairs.size() - 1;
            int leftMatch = -1, rightMatch = -1;
            // pick left most match
            while (lo <= hi){
                int mid = lo + (hi - lo)/2;
                Pair<Integer, Integer> now = pairs.get(mid);
                if(now.first == target){
                    leftMatch = mid;
                    hi = mid - 1;
                } else if(now.first > target){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            // pick right match
            lo = 0;
            hi = pairs.size() - 1;
            while (lo <= hi){
                int mid = lo + (hi - lo)/2;
                Pair<Integer, Integer> now = pairs.get(mid);
                if(now.first == target){
                    rightMatch = mid;
                    lo = mid + 1;
                } else if(now.first > target){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            // pick a random number between leftMatch and rightMatch;
            int diff = rightMatch - leftMatch;
            int rand = random.nextInt(diff + 1);
            return pairs.get(leftMatch + rand).second;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int[] arr = fr.nextIntArray(n);
        Solution solution = new Solution(arr);
        System.out.println(solution.pick(-760627172));
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
