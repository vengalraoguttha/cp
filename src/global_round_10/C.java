package global_round_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            long ans = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                if(stack.isEmpty()){
                    stack.add(arr[i]);
                }else {
                    int val = stack.peek();
                    if(val > arr[i]){
                        stack.push(arr[i]);
                    }else if(val < arr[i]){
                        long tot = 0;
                        boolean has = false;
                        while (!stack.isEmpty()){
                            int temp = stack.pop();
                            if(temp >= arr[i]){
                                //has = true;
                                stack.push(temp);
                                break;
                            }
                            if(!stack.isEmpty())
                            tot += Math.min(stack.peek(), arr[i]) - temp;
                        }
//                        if(has){
//                            ans += tot;
//                        }
                        ans += tot;
                        stack.push(arr[i]);
                    }
                }
            }
            long tot = 0;
            while (!stack.isEmpty()){
                int temp = stack.pop();
                if(!stack.isEmpty())
                    tot += stack.peek() - temp;
            }
            ans += tot;
            sb.append(ans).append("\n");
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
