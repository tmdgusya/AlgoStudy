package BackjunJudge;

import java.util.Scanner;

public class Back9021 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            String parenthesis = scanner.nextLine();
            if(!isVPS(parenthesis.split(""))) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }

    }

    public static boolean isVPS(String[] parenthesis) {
        int count = 0;
        for(String p : parenthesis) {
            if(p.equals("(")) ++count;
            if(p.equals(")")) --count;
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}
