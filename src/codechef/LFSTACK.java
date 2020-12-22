package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LFSTACK {
    private static boolean calculate(Stack<Integer> stack, LinkedList<Integer>[] lists){
        boolean yes = false;
        if(stack.isEmpty()) return true;
        int x = stack.pop();
        for(int i = 0; i < lists.length; i++){
            if(lists[i].size() == 0) continue;
            if(lists[i].get(0) == x){
                lists[i].removeFirst();
                yes = yes || calculate(stack, lists);
                if(yes) break;
                lists[i].addFirst(x);
            }
        }
        stack.push(x);
        return yes;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        // code goes here
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            LinkedList<Integer>[] lists = new LinkedList[n];
            int total = 0;
            for(int i = 0; i < n; i++){
                //StringTokenizer st = new StringTokenizer(br.readLine());
                int size = sc.nextInt();
                total += size;
                lists[i] = new LinkedList<>();
                for(int j = 0; j < size; j++){
                    int current = sc.nextInt();
                    lists[i].add(current);
                }
            }
            Stack<Integer> stack = new Stack<>();
            //StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < total; i++){
                stack.push(sc.nextInt());
            }

            if(calculate(stack, lists)){
                sb.append("Yes\n");
            }else {
                sb.append("No\n");
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
