package acl_big_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    private static FastReader fr = new FastReader();
    private static PrintWriter out=new PrintWriter(System.out);

    private static int[] dp;

    // A utility function to get the
    // middle index of given range.
    static int getMid(int s, int e)
    {
        return s + (e - s) / 2;
    }

    /*
    * A recursive function to get the sum
    of values in given range of the array.
    * The following are parameters for this function.
    *
    * st -> Pointer to segment tree
    * node -> Index of current node in
    *         the segment tree.
    * ss & se -> Starting and ending indexes
    *         of the segment represented
    *         by current node, i.e., st[node]
    * l & r -> Starting and ending indexes
    *         of range query
    */
    static int MaxUtil(int[] st, int ss, int se,
                       int l, int r, int node)
    {

        // If segment of this node is completely
        // part of given range, then return
        // the max of segment
        if (l <= ss && r >= se)
            return st[node];

        // If segment of this node does not
        // belong to given range
        if (se < l || ss > r)
            return -1;

        // If segment of this node is partially
        // the part of given range
        int mid = getMid(ss, se);

        return Math.max(MaxUtil(st, ss, mid, l, r, 2 * node + 1),
                MaxUtil(st, mid + 1, se, l, r, 2 * node + 2));
    }

    /*
    * A recursive function to update the
    nodes which have the given index in their
    * range. The following are parameters
    st, ss and se are same as defined above
    * index -> index of the element to be updated.
    */
    static void updateValue(int arr[], int[] st, int ss,
                            int se, int index, int value, int node)
    {
        if (index < ss || index > se)
        {
            System.out.println("Invalid Input");
            return;
        }

        if (ss == se)
        {

            // update value in array and in segment tree
            arr[index] = value;
            st[node] = value;
        }
        else
        {
            int mid = getMid(ss, se);

            if (index >= ss && index <= mid)
                updateValue(arr, st, ss, mid, index, value, 2 * node + 1);
            else
                updateValue(arr, st, mid + 1, se, index, value, 2 * node + 2);

            st[node] = Math.max(st[2 * node + 1], st[2 * node + 2]);
        }
        return;
    }

    // Return max of elements in range from
    // index l (query start) to r (query end).
    static int getMax(int[] st, int n, int l, int r)
    {

        // Check for erroneous input values
        if (l < 0 || r > n - 1 || l > r)
        {
            System.out.printf("Invalid Input\n");
            return -1;
        }

        return MaxUtil(st, 0, n - 1, l, r, 0);
    }

    // A recursive function that constructs Segment
    // Tree for array[ss..se]. si is index of
    // current node in segment tree st
    static int constructSTUtil(int arr[], int ss,
                               int se, int[] st, int si)
    {

        // If there is one element in array, store
        // it in current node of segment tree and return
        if (ss == se)
        {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then
        // recur for left and right subtrees and
        // store the max of values in this node
        int mid = getMid(ss, se);

        st[si] = Math.max(constructSTUtil(arr, ss, mid, st, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, st, si * 2 + 2));

        return st[si];
    }

    /*
    * Function to construct segment tree from
    given array. This function allocates
    * memory for segment tree.
    */
    static int[] constructST(int arr[], int n)
    {

        // Height of segment tree
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));

        // Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        // Allocate memory
        int[] st = new int[max_size];

        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, st, 0);

        // Return the constructed segment tree
        return st;
    }

    private static int calculate(int current, int[] arr, int k, int[] st){
        int low = arr[current] - k + 300000;
        int high = arr[current] + k + 300000;
        int max = getMax(st, 1000005, low, high);
//        for(int i = low; i <= high; i++){
//            System.out.println(dp[i]);
//        }
        updateValue(dp, st, 0, 1000005 - 1, arr[current] + 300000, max + 1, 0);
        return max + 1;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = fr.nextInt();
        int k = fr.nextInt();

        int[] arr = fr.nextIntArray(n);

        dp = new int[1000005];
        int[] st = constructST(dp, 1000005);

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, calculate(i, arr, k, st));
        }

        sb.append(max);
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
