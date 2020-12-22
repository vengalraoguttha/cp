package atcoder_bc_177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        int setGcd = arr[0];
        for(int i = 1; i < n; i++){
            setGcd = gcd(setGcd, arr[i]);
        }
        if(setGcd > 1){
            sb.append("not coprime");
        }else {
            int[] vals = new int[1000005];
            Arrays.fill(vals, -1);
            vals[1] = 1;
            for(int i = 2; i < vals.length; i++){
                for(int j = i; j < vals.length; j+=i){
                    if(vals[j] == -1){
                        vals[j] = i;
                    }
                }
            }

            Set<Integer> divisors = new HashSet<>();
            boolean isPair = true;
            for(int i = 0; i < n; i++){
                int val = arr[i];
                List<Integer> currentDiv = new ArrayList<>();
                while (val > 1){
                    int div = vals[val];
                    if(divisors.contains(div)){
                        isPair = false;
                        break;
                    }
                    currentDiv.add(div);
                    val /= div;
                }
                divisors.addAll(currentDiv);
                if(!isPair) break;
            }
            if(isPair){
                sb.append("pairwise coprime");
            }else {
                sb.append("setwise coprime");
            }
        }
        System.out.print(sb.toString());
    }

    private static int gcd(int a, int b){
        if(a < b) return gcd(b, a);
        if(a % b == 0) return b;
        return gcd(b, a % b);
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
