package round665_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] in = nextIntArray(br, 2);
            int n = in[0];
            int k = in[1];
            if(n % 2 == 0 && k % 2 == 0 && k <= n){
                sb.append(0).append("\n");
            }else if(n % 2 == 1 && k % 2 == 1 && k <= n){
                sb.append(0).append("\n");
            }else if(k <= n){
                sb.append(1).append("\n");
            }else {
                sb.append(k - n).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static boolean find(int val, int k){
        int start = 0;
        int end = val;
        while (start <= end){
            int mid = start + (end - start)/2;
            int res = Math.abs(mid - Math.abs(val - mid));
            if(res == k){
                return true;
            } else if(res > k){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
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

