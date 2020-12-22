package round664_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] arr = nextIntArray(br, 2);
        int n = arr[0];
        int m = arr[1];
        int[] a = nextIntArray(br, n);
        int[] b = nextIntArray(br, m);

        List<List<Integer>> lists = new ArrayList<>();
        int maxMin = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < m; j++){
                list.add(a[i] & b[j]);
            }
            list.sort(null);
            lists.add(list);
            maxMin = Math.max(maxMin, list.get(0));
        }

        int ans = maxMin;

        for(int i = 0; i < n; i++){
            List<Integer> list = lists.get(i);
            int temp = ans | list.get(0);
            for(int j = 0; j < list.size(); j++){
                temp = Math.min(temp, ans | list.get(j));
            }
            ans = temp;
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
