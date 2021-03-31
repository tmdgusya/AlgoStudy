package BackjunJudge;

import java.util.Scanner;
import java.util.Stack;

public class Back10773 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for(int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            if(data == 0) {
                stack.pop();
                continue;
            }
            stack.push(data);
        }

        for(int i : stack) {
            sum+=i;
        }

        System.out.println(sum);
    }

}
