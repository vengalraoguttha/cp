package kickstart_round_e;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++ ){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= Math.min(i, j); k++){
                    System.out.println(n+" "+i+" "+j+" "+k);
                }
            }
        }
    }
}
