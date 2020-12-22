package round685_div2;

public class Test {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            System.out.print(0);
        }
        System.out.println();
        int x = 0;
        for(int i = 1; i <= 10; i++){
            for(int j = i + 1; j <= 10; j++){
                System.out.println(i+" "+j);
                x++;
            }
        }
        System.out.println(x);
    }
}
