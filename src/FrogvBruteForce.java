import java.util.Scanner;

public class FrogvBruteForce {
    private static boolean canReach(int x, int y, int[] arr, int k, boolean[] visited){
        if(x == y) return true;
        int min = Math.min(arr[x], arr[y]);
        visited[x] = true;
        boolean canReach = false;
        for(int i = 0; i < arr.length; i++){
            if(i == x || visited[i]) continue;
            if(arr[i] - min >= 0 && arr[i] - min <= k){
                if(i == y){
                    canReach = true;
                    break;
                }
                canReach = canReach || canReach(i, y, arr, k, visited);
            }
        }
        return canReach;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < p; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            boolean[] visited = new boolean[n];
            if(arr[a - 1] > arr[b - 1]){
                int t = a;
                a = b;
                b = t;
            }
            if(canReach(a - 1, b - 1, arr, k, visited)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
