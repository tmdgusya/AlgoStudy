package BackjunJudge;

import java.util.Scanner;

public class Back9021 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < N; i++) {
            String line = scan.nextLine();
            String[] brackets = line.split("");
            boolean answer = isTrue(brackets);
            if(answer) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isTrue(String[] brackets) {
        int answer = 0;
        for (String bracket : brackets) {
            if (bracket.equals("(")) {
                ++answer;
            }
            if (bracket.equals(")")) {
                --answer;
            }
            if (answer < 0) {
                return false;
            }
        }
        return answer == 0;
    }

}
