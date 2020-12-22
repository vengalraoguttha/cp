package education_round_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            Arrays.sort(arr);
            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int start = 0;
                int end = n - 1;
                int left = -1, right = -1;
                while (start <= end){
                    int mid = start + (end - start)/2;
                    if(arr[mid] == arr[i]){
                        left = mid;
                        end = mid - 1;
                    }else if(arr[mid] < arr[i]){
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
                start = 0;
                end = n - 1;
                while (start <= end){
                    int mid = start + (end - start)/2;
                    if(arr[mid] == arr[i]){
                        right = mid;
                        start = mid + 1;
                    }else if(arr[mid] < arr[i]){
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
                int count = right - left + 1;
                if(count > 1){
                    count = (count)*(count - 1)/2;
                    pairs.add(new Pair<>(arr[i], count));
                }
                i = right;
            }
            long ans = 0;
            for(int i = 0; i < pairs.size(); i++){
                for(int j = i + 1; j < pairs.size(); j++){
                    ans += pairs.get(i).second*pairs.get(j).second;
                }
            }
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
