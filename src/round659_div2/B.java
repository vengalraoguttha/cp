package round659_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
    static HashMap<String, Boolean> map = new HashMap<>();
    private static boolean calculate(int time, int[] d, int k, int l, int current){
        if(current >= d.length) {
            return true;
        }
        if(map.containsKey(time+"-"+current)){
            return map.get(time+"-"+current);
        }
        if(d[current] + change(time, k) > l) {
            map.put(time+"-"+current, false);
            return false;
        }
        int wait = l - d[current] - change(time, k);
        boolean ok = false;
        int t = time;
        t = t % (2*k);
        if(t >= k) wait = 2*(d[current] + change(time, k));

        int a = l - d[current];
        if(d[current] + k <= l) wait = 2*k;

        for(int i = 0; i <= wait; i++){
            ok = ok || calculate((time + i + 1), d, k, l, current + 1);
        }
        map.put(time+"-"+current, ok);
        return ok;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] a = nextIntArray(br, 3);
            int n = a[0];
            int k = a[1];
            int l = a[2];
            int[] d = nextIntArray(br, n);
            boolean ok = false;
            map = new HashMap<>();
            for(int i = 0; i < 2*k; i++){
                ok = ok || calculate(i + 1, d, k, l, 0);
            }
            if(ok)
                sb.append("Yes\n");
            else
                sb.append("No\n");
        }
        System.out.print(sb.toString());
    }

    private static int change(int time, int k){
        time = time % (2*k);
        if(time <= k) return time;
        return k - (time % k);
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
