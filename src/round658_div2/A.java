package round658_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] r = nextIntArray(br, 2);
            int[] a = nextIntArray(br, r[0]);
            int[] b = nextIntArray(br, r[1]);
            Set<Integer> set = new HashSet<>();
            for(int val : a){
                set.add(val);
            }
            boolean found = false;
            int ans = -1;
            for(int val : b){
                if(set.contains(val)){
                    found = true;
                    ans = val;
                    break;
                }
            }
            if(found){
                sb.append("YES\n");
                sb.append("1 ").append(ans).append("\n");
            }else {
                sb.append("NO\n");
            }
        }
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
