package kickstart_round_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        int test = 1;
        while (t-- > 0){
            int[] arr = nextIntArray(br, 4);
            if(arr[0] < arr[3] + (arr[1] - arr[3]) + (arr[2] - arr[3])){
                System.out.println("Case #"+test+": IMPOSSIBLE");
                test++;
                continue;
            }
            if(arr[3] == 0){
                System.out.println("Case #"+test+": IMPOSSIBLE");
                test++;
                continue;
            }
            if(arr[0] == 1){
                if(arr[1] == 1 && arr[2] == 1 && arr[3] == 1){
                    System.out.println("Case #"+test+": 1");
                    test++;
                    continue;
                }else {
                    System.out.println("Case #"+test+": IMPOSSIBLE");
                    test++;
                    continue;
                }
            }
            int diff1 = arr[1] - arr[3];
            int diff2 = arr[2] - arr[3];
            int[] c = new int[arr[0]];
            int current = arr[0];
            if(diff1 != 0 && diff2 != 0){
                for(int i = diff1; i < diff1 + arr[3]; i++){
                    c[i] = current;
                }
                int x = current - diff1;
                for(int i = 0; i < diff1; i++){
                    c[i] = x;
                    x++;
                }
                current = current - diff1 - 1;
                for(int i = diff1 + arr[3]; i < arr[0] - diff2; i++){
                    c[i] = 1;
                }
                for(int i = arr[0] - diff2; i < arr[0]; i++){
                    c[i] = current;
                    current--;
                }
            }else if(diff2 == 0 && diff1 != 0){
                for(int i = arr[0] - arr[3]; i < arr[0]; i++){
                    c[i] = current;
                }
                int x = current - diff1;
                for(int i = 0; i < diff1; i++){
                    c[i] = x;
                    x++;
                }
                for(int i = diff1; i < arr[0] - arr[3]; i++){
                    c[i] = 1;
                }
            }else if(diff1 == 0 && diff2 != 0){
                for(int i = diff1; i < diff1 + arr[3]; i++){
                    c[i] = current;
                }
                int x = current - diff1;
                for(int i = 0; i < diff1; i++){
                    c[i] = x;
                    x++;
                }
                current = current - diff1 - 1;
                for(int i = diff1 + arr[3]; i < arr[0] - diff2; i++){
                    c[i] = 1;
                }
                for(int i = arr[0] - diff2; i < arr[0]; i++){
                    c[i] = current;
                    current--;
                }
            }else {
                if(arr[3] < 2){
                    System.out.println("Case #"+test+": IMPOSSIBLE");
                    test++;
                    continue;
                }
                for(int i = 0; i < arr[0]; i++){
                    c[i] = current;
                }
                for(int i = 1; i < 1 + arr[0] - arr[3]; i++){
                    c[i] = 1;
                }
            }

            System.out.print("Case #"+test+": ");
            for(int i = 0; i < c.length; i++){
                System.out.print(c[i]+" ");
            }
            System.out.println();
            test++;
        }
        //System.out.print(sb.toString());
    }

    private static void validate(int[] c, int[] arr, int test){
        int[] a = new int[arr[0] + 1];
        int[] b = new int[arr[0] + 1];
        a[c[0]]++;
        int max = c[0];
        for(int i = 1; i < c.length; i++){
            if(max <= c[i]){
                a[c[i]]++;
            }
            max = Math.max(max, c[i]);
        }
        max = c[c.length - 1];
        b[c[c.length - 1]]++;
        for(int i = c.length - 2; i >= 0; i--){
            if(max <= c[i]){
                b[c[i]]++;
            }
            max = Math.max(max, c[i]);
        }
        int x = 0, y = 0, z = 0;
        for(int i = a.length - 1; i >= 0; i--){
            if(a[i] != 0) x += a[i];
            if(b[i] != 0) y += b[i];
            if(z == 0)
            z += Math.min(a[i], b[i]);
        }
        if(x == arr[1] && y == arr[2] && z == arr[3]){
            System.out.println("Match : "+ test);
        }else {
            System.out.println("No Match : "+ test);
        }
        assert x == arr[1];
        assert y == arr[2];
        assert z == arr[3];
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
