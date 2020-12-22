package atcoder_bc_176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] in = nextIntArray(br, 3);
        int[] rows = new int[in[0]];
        int[] cols = new int[in[1]];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < in[2]; i++){
            int[] arr = nextIntArray(br, 2);
            map.put(arr[0]+"-"+arr[1], 0);
            rows[arr[0] - 1]++;
            cols[arr[1] - 1]++;
        }
        int maxrow = 0;
        for(int i = 0; i < in[0]; i++){
            maxrow = Math.max(maxrow, rows[i]);
        }
        List<Integer> maxRowId = new ArrayList<>();
        for(int i = 0; i < in[0]; i++){
            if(maxrow == rows[i]){
                maxRowId.add(i);
            }
        }
        int maxcol = 0;
        for(int i = 0; i < in[1]; i++){
            maxcol = Math.max(maxcol, cols[i]);
        }
        List<Integer> maxColId = new ArrayList<>();
        for(int i = 0; i < in[1]; i++){
            if(maxcol == cols[i]){
                maxColId.add(i);
            }
        }
        boolean has = true;
        for(int i = 0; i < maxRowId.size(); i++){
            for(int j = 0; j < maxColId.size(); j++){
                int x = maxRowId.get(i);
                int y = maxColId.get(j);
                if(!map.containsKey((x + 1)+"-"+(y + 1))){
                    has = false;
                    break;
                }
            }
        }
        if(!has)
        sb.append(maxcol + maxrow);
        else sb.append(maxcol + maxrow - 1);
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
