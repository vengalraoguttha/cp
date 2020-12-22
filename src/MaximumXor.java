import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaximumXor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        Stack<Pair<Long, Integer>> stack = new Stack<>();
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(stack.size() < 1){
                stack.add(new Pair<>((long) arr[i], i));
            }else {
                if(stack.peek().first >= arr[i]) {
                    stack.add(new Pair<>((long) arr[i], i));
                    continue;
                }
                while (!stack.isEmpty()){
                    if(stack.peek().first >= arr[i]) break;
                    Pair<Long, Integer> pair = stack.pop();
                    max = Math.max(max, pair.first ^ arr[i]);
                    if(!stack.isEmpty())
                    max = Math.max(max, pair.first ^ stack.peek().first);
                }
                stack.add(new Pair<>((long) arr[i], i));
            }
        }
        while (!stack.isEmpty()){
            Pair<Long, Integer> pair = stack.pop();
            if(!stack.isEmpty())
                max = Math.max(max, pair.first ^ stack.peek().first);
        }
        sb.append(max);
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
