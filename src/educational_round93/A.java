package educational_round93;

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
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            boolean found = false;
            for(int i = 1; i < n-1; i++){
                int sum = arr[i] + arr[0];
                int diff = arr[i + 1] - arr[i];
                int min = arr[0];
                int max = arr[n - 1];
                if(sum <= max){
                    found = true;
                    sb.append(1).append(" ").append(i + 1).append(" ").append(n).append("\n");
                    break;
                } else if(arr[n - 1] - arr[i] >= arr[0]){
                    found = true;
                    sb.append(1).append(" ").append(i + 1).append(" ").append(n).append("\n");
                    break;
                } else if(arr[n - 1] - arr[0] >= arr[i]){
                    found = true;
                    sb.append(1).append(" ").append(i + 1).append(" ").append(n).append("\n");
                    break;
                }
            }
//            if(arr[n - 1] - arr[0] >= arr[0]){
//                found = true;
//                sb.append(n).append(" ").append(1).append(" ").append(1).append("\n");
//                break;
//            }
            if(!found){
                sb.append(-1).append("\n");
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

