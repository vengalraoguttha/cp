import java.util.*;

public class FROGV {
    private static int calculate(int current, int[] dp, int[] arr, int K){
        if(dp[current] != -1) return dp[current];
        int key = arr[current] + K + 1;
        int val = Arrays.binarySearch(arr, key);
        if(val < 0){
            val = -val - 1;
        }
        int max = current;
        for(int i = current + 1; i < val; i++){
            max = Math.max(max, calculate(i, dp, arr, K));
        }
        dp[current] = max;
        return max;
    }
    public static void main(String[] args) {
        int N, K, P;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        P = sc.nextInt();
        int[] arr = new int[N];
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            list.add(new Pair(arr[i], i));
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a - o2.a;
            }
        });
        Arrays.sort(arr);
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        for(int i = 0; i < N; i++){
            dp[i] = calculate(i, dp, arr, K);
        }
        StringBuilder sb = new StringBuilder();
        int A, B;
        for(int i = 0; i < P; i++){
            A = sc.nextInt();
            B = sc.nextInt();
            int min = Math.min(A, B);
            int max = Math.max(A, B);
            if(dp[min - 1] >= max - 1){
                sb.append("Yes").append("\n");
            }else {
                sb.append("No").append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static class Pair{
        int a, b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
