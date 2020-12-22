package round641_div2;

import java.util.Random;

public class RamdomGen {
    public static void main(String[] args) {
        Random random = new Random(Integer.parseInt(args[0]));
        int n = random.nextInt(9) + 2;
        int k = random.nextInt(20);
        int p = 1;
        System.out.println(n+" "+k+" "+p);
        for(int i = 0; i < n; i++){
            System.out.print(random.nextInt(10)+" ");
        }
        System.out.println();
        for(int i = 0; i < p; i++){
            System.out.println((random.nextInt(n - 1) + 1)+" "+(random.nextInt(n - 1) + 1));
        }
    }
}
