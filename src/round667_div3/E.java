package round667_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class E {
    private static void merge(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /* l is for left index and r is right index of the
       sub-array of arr to be sorted */
    private static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for
            // large l and h
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int[] in = nextIntArray(br, 2);
            int n = in[0];
            int k = in[1];
            int[] x = nextIntArray(br, n);
            int[] y = nextIntArray(br, n);
            mergeSort(x, 0, n - 1);
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int bs = x[i];
                int be = bs + k;
                int start = i;
                int end = n - 1;
                int pos = -1;
                while (start <= end){
                    int mid = start + (end - start)/2;
                    if(x[mid] < be){
                        start = mid + 1;
                        pos = mid;
                    } else if(x[mid] > be){
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                        pos = mid;
                    }
                }
                int points = pos - i + 1;
                list.add(new Pair<>(pos, points));
            }
            int[] max = new int[n + 1];
            int current = 0;
            for(int i = list.size() - 1; i >= 0; i--){
                current = Math.max(list.get(i).second, current);
                max[i] = current;
            }
            int ans = 0;
            for(int i = 0; i < list.size(); i++){
                Pair<Integer, Integer> pair = list.get(i);
                ans = Math.max(ans, pair.second + max[pair.first + 1]);
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
