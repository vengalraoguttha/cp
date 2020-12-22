package round664_div2;

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
            int[] a = nextIntArray(br, 4);
            if(a[0] % 2 == 0 && a[1] % 2 == 0 && a[2] % 2 == 0){
                sb.append("Yes\n");
                continue;
            }
            if(a[0] == a[1] && a[1] == a[2]){
                sb.append("Yes\n");
                continue;
            }
            int odd = 0;
            if(a[0] % 2 == 1) odd++;
            if(a[1] % 2 == 1) odd++;
            if(a[2] % 2 == 1) odd++;
            if(odd == 1 && a[3] % 2 == 0){
                sb.append("Yes\n");
                continue;
            }else if(odd == 1 && a[3] % 2 == 1){
                sb.append("No\n");
                continue;
            }
            if(odd == 3){
                sb.append("Yes\n");
                continue;
            }
            if(odd == 2 && a[3] % 2 == 0){
                sb.append("No\n");
                continue;
            }else if(odd == 2 && a[3] % 2 == 1){
                if(a[0] != 0 && a[1] != 0 && a[2] != 0)
                sb.append("Yes\n");
                else sb.append("No\n");
                continue;
            }
            sb.append("No\n");
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
