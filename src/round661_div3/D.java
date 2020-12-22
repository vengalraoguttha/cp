package round661_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            String s = br.readLine();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '0') {
                    if(i > 0)
                    arr[i] = arr[i - 1] + 1;
                    else arr[i] = 1;
                }
                else {
                    if(i > 0)
                        arr[i] = arr[i - 1] - 1;
                    else arr[i] = -1;
                }
            }

            for(int i = 0; i < n; i++){
                arr[i] = Math.abs(arr[i]);
            }
            int count = arr[0];
            for(int i = 0; i < n; i++){
                if(arr[i] > count){
                    count++;
                }
            }
            sb.append(count).append("\n");
            int current = arr[0];
            boolean inc = true;
            for(int i = 0; i < n; i++){
                if(arr[i] > current){
                    inc = true;
                    current++;
                    sb.append(current).append(" ");
                }else if(arr[i] < current){
                    if(inc){
                        sb.append(current).append(" ");
                        inc = false;
                    }else {
                        current--;
                        sb.append(current).append(" ");
                    }
                }else {
                    inc = true;
                    sb.append(current).append(" ");
                }
            }
            sb.append("\n");
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
