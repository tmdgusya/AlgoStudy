package CodeSquad.Week2;

import java.util.Scanner;

public class Back1000 {

    public static void main(String[] args) {
        int A;
        int B;
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        int result = add(A, B);
        System.out.println(result);
    }

    static int add(int a, int b){
        return a+b;
    }
}
