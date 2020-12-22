import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NOKIA {
    private static int calculate(int start, int end){
        if(start > end) return 0;
        if(start == end) return end - start + 2;
        return end - start + 2 + calculate(start, start + (end - start)/2 - 1) + calculate(start + (end - start)/2 + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] a = nextIntArray(br, 2);
            int n = a[0];
            int m = a[1];
            int maxLen = ((n + 1) * (n + 2))/2 - 1;
            int minLen = calculate(0, n - 1);
            if(m >= minLen && m <= maxLen){
                sb.append(0).append("\n");
            }else if(m < minLen){
                sb.append(-1).append("\n");
            }else {
                sb.append(m - maxLen).append("\n");
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
