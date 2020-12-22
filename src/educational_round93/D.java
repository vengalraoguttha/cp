package educational_round93;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 3);
        int R = in[0];
        int G = in[1];
        int B = in[2];

        int[] red = nextIntArray(br, R);
        int[] green = nextIntArray(br, G);
        int[] blue = nextIntArray(br, B);

        PriorityQueue<Integer> red_pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> green_pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> blue_pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < R; i++){
            red_pq.add(red[i]);
        }

        for(int i = 0; i < G; i++){
            green_pq.add(green[i]);
        }

        for(int i = 0; i < B; i++){
            blue_pq.add(blue[i]);
        }

        long ans = 0;
        while ((!red_pq.isEmpty() && !green_pq.isEmpty()) ||
                (!green_pq.isEmpty() && !blue_pq.isEmpty()) ||
                (!blue_pq.isEmpty() && !red_pq.isEmpty())){
            int r = -1, g = -1, b = -1;
            if(!red_pq.isEmpty()) r = red_pq.poll();
            if(!green_pq.isEmpty()) g = green_pq.poll();
            if(!blue_pq.isEmpty()) b = blue_pq.poll();

            int min = Math.min(r, Math.min(g, b));
            if(r == g && g == b){
                int rp = -1;
                int gp = -1;
                int bp = -1;
                if(!red_pq.isEmpty()) rp = red_pq.peek();
                if(!green_pq.isEmpty()) gp = green_pq.peek();
                if(!blue_pq.isEmpty()) bp = blue_pq.peek();
                int m = Math.min(rp, Math.min(gp, bp));
                if(m == rp) red_pq.add(r);
                else if(m == gp) green_pq.add(g);
                else if(m == bp) blue_pq.add(b);
             } else if(min != -1){
                if(min == r) red_pq.add(r);
                else if(min == g) green_pq.add(g);
                else if(min == b) blue_pq.add(b);
            }

            List<Integer> list = new ArrayList<>();
            list.add(r);
            list.add(g);
            list.add(b);
            list.sort(null);

            ans += (list.get(2) * list.get(1));
        }

        sb.append(ans);

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
